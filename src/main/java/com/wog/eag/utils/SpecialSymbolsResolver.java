package com.wog.eag.utils;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.wog.eag.utils.General;
import com.wog.eag.utils.PropertyLoader;

@Configuration
public class SpecialSymbolsResolver implements EnvironmentAware {

	//@Autowired
    private static Environment env;

	
    private static boolean init = true;  
    
    private static final String RDBMS_PROPERTY = "app.rdbms";
    private static String rdbmsValue = null;
    
    private static final String MAIN_SCHEMA_SYMBOL = "[SQL_MS]";
    private static final String MAIN_SCHEMA_PROPERTY = "config.main.schema";
    private static String mainSchemaValue = null;

    private static final String FUNCTION_PREFIX_SYMBOL = "[SQL_FP]";
    private static final String FUNCTION_PREFIX_PROPERTY = "config.function.prefix";
    private static String functionPrefixValue = null;

    private static final String CONCAT_SYMBOL = "[SQL_CS]";
    private static final String CONCAT_SYMBOL_PROPERTY = "config.concat.symbol";
    private static String concatSymbolValue = null;
    
    private static final String CLAUSE_READONLY = "config.clause.readonly";
    private static String clauseReadonly = null; 
    
    private static final String ONE_ROW_INITIAL = "[SQL_ONEROW_INI]";
    private static final String ONE_ROW = "[SQL_ONEROW]";
    private static final String ONE_ROW_PROPERTY = "config.one.row";
    private static String oneRowValue = null;
    
    private static final String ROW_N = "[SQL_@NROW@ROW]";
    private static final String ROW_N_PROPERTY = "config.n.row";
    private static String ROW_N_Value = null;
    
    private static String VACIO_SYMBOL = "''";
    private static final String VACIO_SYMBOL_PROPERTY = "config.vacio.symbol";
    private static String vacioSymbolValue = null;
    
    private static final String MESSAGE_ERROR_PROPERTY = "config.message.error";
    private static String messageErrorValue = null;
    

    public static String resolveStatement(StringBuffer statement) {
        
        return resolveStatement(statement.toString(), false);
    }
    
    public static String resolveStatement(String statement) {
        return resolveStatement(statement.toString(), false);
    }
    
    public static String resolveStatement(StringBuffer statement, boolean debug) {
        
        return resolveStatement(statement.toString(), debug);
    }
    
    public static String resolveStatement(String statement, boolean debug) {

        init();
        
        if (debug){
            System.out.println("Statement inicial: " + statement);
        }
        
        validarSqlStatement(statement);
        
        if (debug){
            System.out.println("Validacion satisfactoria");
        }
        
        String sqlResolved = statement
                    .replace(MAIN_SCHEMA_SYMBOL, mainSchemaValue)
                    .replace(FUNCTION_PREFIX_SYMBOL, functionPrefixValue)
                    .replace(CONCAT_SYMBOL, concatSymbolValue);
        
        if (debug){
            System.out.println("Resultado remplazo b�sico: " + sqlResolved);
        }
        
        sqlResolved = replaceOneRow(sqlResolved);
        
        if (debug){
            System.out.println("Resultado reemplazo b�sico: " + sqlResolved);
        }
        
        sqlResolved = replaceNRow(sqlResolved, "2000");
        sqlResolved = replaceNRow(sqlResolved, "1000");
        sqlResolved = replaceNRow(sqlResolved, "500");
        sqlResolved = replaceNRow(sqlResolved, "200");
        sqlResolved = replaceNRow(sqlResolved, "100");
        sqlResolved = replaceNRow(sqlResolved, "50");
        sqlResolved = replaceNRow(sqlResolved, "20");
        sqlResolved = replaceNRow(sqlResolved, "10");
        
        if (debug){
            System.out.println("Resultado reemplazo replaceNRow: " + sqlResolved);
        }
        
        sqlResolved = replaceVacio(sqlResolved);
                    
        if (debug){
            System.out.println("Resultado reemplazo replaceVacio: " + sqlResolved);
        }
        
        if ( sqlResolved.trim().toUpperCase().startsWith( "SELECT" ) ) {
            sqlResolved = sqlResolved
                        .concat( " " )
                        .concat( clauseReadonly );
        }
        
        if (debug){
            System.out.println("Resultado reemplazo replaceReadOnly: " + sqlResolved);
        }
        
        return sqlResolved;
            
    }

    private static String replaceOneRow ( String sqlStatement ) {
       
        String sqlRepace = sqlStatement;
        try {
            if ( sqlRepace.contains( ONE_ROW ) ) {
            
                if ( StringUtils.isNotBlank( oneRowValue ) && rdbmsValue.equalsIgnoreCase( "ORACLE" ) ) {
                    sqlRepace = replaceOneRowOracle(sqlRepace);
                } else if(StringUtils.isNotBlank( oneRowValue ) && rdbmsValue.equalsIgnoreCase( "SQLServer" )) {
                    sqlRepace = replaceOneRowSQLServer(sqlRepace);
                } else if(StringUtils.isNotBlank( oneRowValue ) && rdbmsValue.equalsIgnoreCase( "DB2" ) ) {
                    sqlRepace = sqlRepace.replace( ONE_ROW, oneRowValue );
                    sqlRepace = sqlRepace.replace( ONE_ROW_INITIAL, "" );
                }
                //Se llama de forma recursiva la funci�n por si exiten m�s cadenas que deban ser remplazadas 
                return replaceOneRow(sqlRepace);
            }
        } catch (Exception e) {
            System.out.println("ERROR REMPLAZANDO " + ONE_ROW + " - " + e.getMessage());
        }
        
        if (sqlStatement.contains( ONE_ROW )){
            sqlRepace = replaceOneRow ( sqlStatement );
        }
        
        return sqlRepace;
    }
    
    private static String replaceOneRowOracle ( String sqlStatement ) {
        
        String sqlRepace = sqlStatement;
        
        int indexRow = sqlRepace.indexOf( ONE_ROW );
        int indexRowInitialOrg = sqlRepace.lastIndexOf( ONE_ROW_INITIAL );
        int indexRowInitial = indexRowInitialOrg;
        if ( indexRowInitial < 0){
            indexRowInitial= 0;
        }
        
        sqlRepace = sqlRepace.substring(indexRowInitial, indexRow + ONE_ROW.length());
        sqlRepace = sqlRepace.replace( ONE_ROW, "" );
        sqlRepace = sqlRepace.replace( ONE_ROW_INITIAL, "" );
        
        int index = StringUtils.lastIndexOf( sqlRepace.toUpperCase(), "ORDER BY" );
        if ( index != -1 ) {
            if(indexRowInitialOrg != -1){
                sqlRepace = " SELECT * FROM (" + sqlRepace + ") WHERE " + oneRowValue;
            } else {
                
                int indexSelect = StringUtils.lastIndexOf( sqlRepace.toUpperCase(), "SELECT" );
                sqlRepace = sqlRepace.substring(indexSelect, sqlRepace.length());
                sqlRepace = " SELECT * FROM (" + sqlRepace + ") WHERE " + oneRowValue;
                indexRowInitial = indexSelect;
            }
            
        } else {
            sqlRepace = sqlRepace.concat( " AND " + oneRowValue );
        }
        
        sqlRepace = sqlStatement.substring(0, indexRowInitial) + sqlRepace + sqlStatement.substring(indexRow + ONE_ROW.length(), sqlStatement.length());
        
        return sqlRepace;
        
    }
    
    private static String replaceOneRowSQLServer ( String sqlStatement ) {
        
        String sqlRepace = sqlStatement;
        
        int indexRow = sqlRepace.indexOf( ONE_ROW );
        int indexRowInitialOrg = sqlRepace.lastIndexOf( ONE_ROW_INITIAL );
        int indexRowInitial = indexRowInitialOrg;
        if ( indexRowInitial < 0){
            indexRowInitial= 0;
        }
        
        sqlRepace = sqlRepace.substring(indexRowInitial, indexRow + ONE_ROW.length());
        sqlRepace = sqlRepace.replace( ONE_ROW, "" );
        sqlRepace = sqlRepace.replace( ONE_ROW_INITIAL, "" );
        
        int indexSelect = 0;
        if(indexRowInitialOrg != -1){
            indexSelect = StringUtils.indexOf( sqlRepace.toUpperCase(), "SELECT" ) + 6;
        } else {
            indexSelect = StringUtils.lastIndexOf( sqlRepace.toUpperCase(), "SELECT" ) + 6;
        }
        
        sqlRepace = sqlRepace.substring(indexSelect, sqlRepace.length());
        sqlRepace = "SELECT " + oneRowValue + sqlRepace;
        indexRowInitial = indexSelect - 6;
        
        sqlRepace = sqlStatement.substring(0, indexRowInitial) + sqlRepace + sqlStatement.substring(indexRow + ONE_ROW.length(), sqlStatement.length());
        
        return sqlRepace;
        
    }
    
    private static String replaceNRow ( String sqlStatement, String nRow ) {
        
        String sqlRepace = sqlStatement;
        
        String rowN = ROW_N.replace( "@NROW@", nRow );
        String rowNInitial = rowN.replace( "ROW", "ROW_INI");
        String rowNValue = ROW_N_Value.replace( "@NROW@", nRow );
        
        
        try {
            if ( sqlRepace.contains( rowN ) ) {
            
                if ( StringUtils.isNotBlank( rowNValue ) && rdbmsValue.equalsIgnoreCase( "ORACLE" ) ) {
                    
                    sqlRepace =  replaceNRowOracle(sqlRepace, rowN, rowNInitial, rowNValue);
                    
                } else if(StringUtils.isNotBlank( rowNValue ) && rdbmsValue.equalsIgnoreCase( "SQLServer" ) ) {
                    
                    sqlRepace = replaceNRowSQLServer(sqlRepace, rowN, rowNInitial, rowNValue);
                    
                } else if(StringUtils.isNotBlank( rowNValue ) && rdbmsValue.equalsIgnoreCase( "DB2" ) ) {
                    sqlRepace = sqlRepace.replace( rowN, rowNValue );
                    sqlRepace = sqlRepace.replace( rowNInitial, "" );
                }
                //Se llama de forma recursiva la funci�n por si exiten m�s cadenas que deban ser remplazadas 
                return replaceNRow(sqlRepace, nRow);
            }
        } catch (Exception e) {
            System.out.println("ERROR REMPLAZANDO " + rowN + " - " + e.getMessage());
        }
        return sqlRepace;
    }
    
    private static String replaceNRowOracle ( String sqlStatement, String rowN , String rowNInitial , String rowNValue ) {
        
        String sqlRepace = sqlStatement;
        
        int indexRow = sqlRepace.indexOf( rowN );
        int indexRowInitialOrg = sqlRepace.lastIndexOf( rowNInitial );
        int indexRowInitial = indexRowInitialOrg;
        if ( indexRowInitial < 0){
            indexRowInitial= 0;
        }
        
        sqlRepace = sqlRepace.substring(indexRowInitial, indexRow + rowN.length());
        sqlRepace = sqlRepace.replace( rowN, "" );
        sqlRepace = sqlRepace.replace( rowNInitial, "" );
        
        int index = StringUtils.lastIndexOf( sqlRepace.toUpperCase(), "ORDER BY" );
        if ( index != -1 ) {
            if(indexRowInitialOrg != -1){
                sqlRepace = " SELECT * FROM (" + sqlRepace + ") WHERE " + rowNValue;
            } else {
                
                int indexSelect = StringUtils.lastIndexOf( sqlRepace.toUpperCase(), "SELECT" );
                sqlRepace = sqlRepace.substring(indexSelect, sqlRepace.length());
                sqlRepace = " SELECT * FROM (" + sqlRepace + ") WHERE " + rowNValue;
                indexRowInitial = indexSelect;
            }
            
        } else {
            sqlRepace = sqlRepace.concat( " AND " + rowNValue );
        }
        
        sqlRepace = sqlStatement.substring(0, indexRowInitial) + sqlRepace + sqlStatement.substring(indexRow + rowN.length(), sqlStatement.length());
        
        return sqlRepace;
        
    }
    
    private static String replaceNRowSQLServer ( String sqlStatement, String rowN , String rowNInitial , String rowNValue ) {
        
        String sqlRepace = sqlStatement;
        
        int indexRow = sqlRepace.indexOf( rowN );
        int indexRowInitialOrg = sqlRepace.lastIndexOf( rowNInitial );
        int indexRowInitial = indexRowInitialOrg;
        if ( indexRowInitial < 0){
            indexRowInitial= 0;
        }
        
        sqlRepace = sqlRepace.substring(indexRowInitial, indexRow + rowN.length());
        sqlRepace = sqlRepace.replace( rowN, "" );
        sqlRepace = sqlRepace.replace( rowNInitial, "" );
        
        int indexSelect = 0;
        if(indexRowInitialOrg != -1){
            indexSelect = StringUtils.indexOf( sqlRepace.toUpperCase(), "SELECT" ) + 6;
        } else {
            indexSelect = StringUtils.lastIndexOf( sqlRepace.toUpperCase(), "SELECT" ) + 6;
        }
        
        sqlRepace = sqlRepace.substring(indexSelect, sqlRepace.length());
        sqlRepace = "SELECT " + rowNValue + sqlRepace;
        indexRowInitial = indexSelect - 6;
        
        sqlRepace = sqlStatement.substring(0, indexRowInitial) + sqlRepace + sqlStatement.substring(indexRow + rowN.length(), sqlStatement.length());
        
        return sqlRepace;
        
    }
    
    private static String replaceVacio ( String sqlStatement) {
        
        String sqlRepace = sqlStatement;
        try {
            if ( SpecialSymbolsResolver.vacioSymbolValue != null) {
                sqlRepace.replaceAll( VACIO_SYMBOL, SpecialSymbolsResolver.vacioSymbolValue );
            }
        } catch (Exception e) {
            System.out.println("ERROR REMPLAZANDO Vacio - " + e.getMessage());
        }
        return sqlRepace;
    }
    
    
    private static void validarSqlStatement(String sqlStatement){
        try {
            if (sqlStatement.contains( "ROWNUM" )){
                throw new Exception(sqlStatement);
            } else if (sqlStatement.contains( "FETCH FIRST" )){
                throw new Exception(sqlStatement);
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        
    }
    
    private static void init() {

        if (init) {
            
            try {
            	
            //    Properties resourceFile = PropertyLoader.loadProperties("src/main/resources/application");
                rdbmsValue = env.getProperty(RDBMS_PROPERTY, "DB2");
                mainSchemaValue = env.getProperty(MAIN_SCHEMA_PROPERTY, General.BLANK);
                functionPrefixValue = env.getProperty(FUNCTION_PREFIX_PROPERTY, General.BLANK);
                concatSymbolValue = env.getProperty(CONCAT_SYMBOL_PROPERTY, "||");
                clauseReadonly = env.getProperty(CLAUSE_READONLY, General.BLANK);
                oneRowValue = env.getProperty(ONE_ROW_PROPERTY, General.BLANK);
                vacioSymbolValue = env.getProperty(VACIO_SYMBOL_PROPERTY, General.BLANK);
                
                ROW_N_Value = env.getProperty(ROW_N_PROPERTY, General.BLANK);
                
                messageErrorValue = env.getProperty(MESSAGE_ERROR_PROPERTY, General.BLANK);
                init = false;
            } catch (Exception e) {

                System.out.println("no encontro la configuracion del codigo de la aplicacion.");
                mainSchemaValue = General.BLANK;
                functionPrefixValue = General.BLANK;
                concatSymbolValue = "||";
                clauseReadonly = General.BLANK;
                oneRowValue = "FETCH FIRST 1 ROWS ONLY";
                vacioSymbolValue = null;
                
                messageErrorValue = "SQLSTATE";
            }
            
            
            
        }

    }
    
    public static String getMessageErrorValue() {
        return messageErrorValue;
    }

	@Override
	public void setEnvironment(Environment environment) {
		SpecialSymbolsResolver.env = environment;
		
	}

}
