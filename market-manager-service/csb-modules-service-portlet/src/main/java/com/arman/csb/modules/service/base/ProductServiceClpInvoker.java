package com.arman.csb.modules.service.base;

import com.arman.csb.modules.service.ProductServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductServiceClpInvoker {
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;
    private String _methodName72;
    private String[] _methodParameterTypes72;
    private String _methodName73;
    private String[] _methodParameterTypes73;
    private String _methodName74;
    private String[] _methodParameterTypes74;
    private String _methodName75;
    private String[] _methodParameterTypes75;
    private String _methodName76;
    private String[] _methodParameterTypes76;

    public ProductServiceClpInvoker() {
        _methodName66 = "getBeanIdentifier";

        _methodParameterTypes66 = new String[] {  };

        _methodName67 = "setBeanIdentifier";

        _methodParameterTypes67 = new String[] { "java.lang.String" };

        _methodName72 = "addProduct";

        _methodParameterTypes72 = new String[] {
                "java.util.Map", "com.liferay.portal.service.ServiceContext"
            };

        _methodName73 = "updateProduct";

        _methodParameterTypes73 = new String[] {
                "java.util.Map", "com.liferay.portal.service.ServiceContext"
            };

        _methodName74 = "search";

        _methodParameterTypes74 = new String[] {
                "java.lang.String", "int", "int", "int",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName75 = "getById";

        _methodParameterTypes75 = new String[] {
                "long", "com.liferay.portal.service.ServiceContext"
            };

        _methodName76 = "updateProductStatus";

        _methodParameterTypes76 = new String[] {
                "long", "int", "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return ProductServiceUtil.getBeanIdentifier();
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            ProductServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return ProductServiceUtil.addProduct((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            return ProductServiceUtil.updateProduct((java.util.Map<java.lang.String, java.lang.Object>) arguments[0],
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName74.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
            return ProductServiceUtil.search((java.lang.String) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[4]);
        }

        if (_methodName75.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
            return ProductServiceUtil.getById(((Long) arguments[0]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[1]);
        }

        if (_methodName76.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
            return ProductServiceUtil.updateProductStatus(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2]);
        }

        throw new UnsupportedOperationException();
    }
}