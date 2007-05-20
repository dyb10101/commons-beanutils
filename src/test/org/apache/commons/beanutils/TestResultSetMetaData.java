/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 


package org.apache.commons.beanutils;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


/**
 * <p>Mock object that implements enough of
 * <code>java.sql.ResultSetMetaData</code>
 * to exercise the {@link ResultSetDyaClass} functionality.</p>
 *
 * @author Craig R. McClanahan
 * @version $Revision$ $Date$
 */

public class TestResultSetMetaData implements InvocationHandler {


    // ----------------------------------------------------- Instance Variables


    /**
     * <p>Array of column names and class names for metadata.</p>
     */
    protected String metadata[][] = {
        { "bigDecimalProperty", "java.math.BigDecimal" },
        { "booleanProperty", Boolean.class.getName() },
        { "byteProperty", Byte.class.getName() },
        { "dateProperty", "java.sql.Date" },
        { "doubleProperty", Double.class.getName() },
        { "floatProperty", Float.class.getName() },
        { "intProperty", Integer.class.getName() },
        { "longProperty", Long.class.getName() },
        { "nullProperty", "java.lang.String" },
        { "shortProperty", Short.class.getName() },
        { "stringProperty", "java.lang.String" },
        { "timeProperty", "java.sql.Time" },
        { "timestampProperty", "java.sql.Timestamp" },
    };


    /**
     * Factory method for creating {@link ResultSetMetaData} proxies.
     *
     * @return A result set meta data proxy
     */
    public static ResultSetMetaData createProxy() {
        ClassLoader classLoader = ResultSetMetaData.class.getClassLoader();
        Class[] interfaces = new Class[] { ResultSetMetaData.class };
        InvocationHandler invocationHandler = new TestResultSetMetaData();
        return (ResultSetMetaData)Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }

    /**
     * Handles method invocation on the {@link ResultSetMetaData} proxy. 
     *
     * @param proxy The proxy ResultSet object
     * @param method the method being invoked
     * @param args The method arguments
     * @return The result of invoking the method.
     * @throws Throwable if an error occurs.
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if ("getColumnClassName".equals(methodName)) {
            return getColumnClassName(((Integer)args[0]).intValue());
        } if ("getColumnCount".equals(methodName)) {
            return new Integer(getColumnCount());
        } if ("getColumnName".equals(methodName)) {
            return getColumnName(((Integer)args[0]).intValue());
        }
        
        throw new UnsupportedOperationException(methodName + " not implemented");
    }

    // ---------------------------------------------------- Implemented Methods


    public String getColumnClassName(int columnIndex) throws SQLException {
        return (metadata[columnIndex - 1][1]);
    }


    public int getColumnCount() throws SQLException {
        return (metadata.length);
    }

    public String getColumnName(int columnIndex) throws SQLException {
        return (metadata[columnIndex - 1][0]);
    }


    // -------------------------------------------------- Unimplemented Methods


    public String getCatalogName(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public int getColumnDisplaySize(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public String getColumnLabel(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public int getColumnType(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public String getColumnTypeName(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public int getPrecision(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public int getScale(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public String getSchemaName(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public String getTableName(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public boolean isAutoIncrement(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public boolean isCaseSensitive(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public boolean isCurrency(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public boolean isDefinitelyWritable(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public int isNullable(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public boolean isReadOnly(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public boolean isSearchable(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public boolean isSigned(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


    public boolean isWritable(int columnIndex) throws SQLException {
        throw new UnsupportedOperationException();
    }


}
