package com.arman.csb.theme.service.base;

import com.arman.csb.theme.model.ContentHolder;
import com.arman.csb.theme.service.ContentHolderService;
import com.arman.csb.theme.service.persistence.ContentHolderPersistence;
import com.arman.csb.theme.service.persistence.TemplatePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the content holder remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.arman.csb.theme.service.impl.ContentHolderServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.theme.service.impl.ContentHolderServiceImpl
 * @see com.arman.csb.theme.service.ContentHolderServiceUtil
 * @generated
 */
public abstract class ContentHolderServiceBaseImpl extends BaseServiceImpl
    implements ContentHolderService, IdentifiableBean {
    @BeanReference(type = com.arman.csb.theme.service.ContentHolderLocalService.class)
    protected com.arman.csb.theme.service.ContentHolderLocalService contentHolderLocalService;
    @BeanReference(type = com.arman.csb.theme.service.ContentHolderService.class)
    protected com.arman.csb.theme.service.ContentHolderService contentHolderService;
    @BeanReference(type = ContentHolderPersistence.class)
    protected ContentHolderPersistence contentHolderPersistence;
    @BeanReference(type = com.arman.csb.theme.service.MyPageLocalService.class)
    protected com.arman.csb.theme.service.MyPageLocalService myPageLocalService;
    @BeanReference(type = com.arman.csb.theme.service.MyPageService.class)
    protected com.arman.csb.theme.service.MyPageService myPageService;
    @BeanReference(type = com.arman.csb.theme.service.TemplateLocalService.class)
    protected com.arman.csb.theme.service.TemplateLocalService templateLocalService;
    @BeanReference(type = com.arman.csb.theme.service.TemplateService.class)
    protected com.arman.csb.theme.service.TemplateService templateService;
    @BeanReference(type = TemplatePersistence.class)
    protected TemplatePersistence templatePersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private ContentHolderServiceClpInvoker _clpInvoker = new ContentHolderServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.arman.csb.theme.service.ContentHolderServiceUtil} to access the content holder remote service.
     */

    /**
     * Returns the content holder local service.
     *
     * @return the content holder local service
     */
    public com.arman.csb.theme.service.ContentHolderLocalService getContentHolderLocalService() {
        return contentHolderLocalService;
    }

    /**
     * Sets the content holder local service.
     *
     * @param contentHolderLocalService the content holder local service
     */
    public void setContentHolderLocalService(
        com.arman.csb.theme.service.ContentHolderLocalService contentHolderLocalService) {
        this.contentHolderLocalService = contentHolderLocalService;
    }

    /**
     * Returns the content holder remote service.
     *
     * @return the content holder remote service
     */
    public com.arman.csb.theme.service.ContentHolderService getContentHolderService() {
        return contentHolderService;
    }

    /**
     * Sets the content holder remote service.
     *
     * @param contentHolderService the content holder remote service
     */
    public void setContentHolderService(
        com.arman.csb.theme.service.ContentHolderService contentHolderService) {
        this.contentHolderService = contentHolderService;
    }

    /**
     * Returns the content holder persistence.
     *
     * @return the content holder persistence
     */
    public ContentHolderPersistence getContentHolderPersistence() {
        return contentHolderPersistence;
    }

    /**
     * Sets the content holder persistence.
     *
     * @param contentHolderPersistence the content holder persistence
     */
    public void setContentHolderPersistence(
        ContentHolderPersistence contentHolderPersistence) {
        this.contentHolderPersistence = contentHolderPersistence;
    }

    /**
     * Returns the my page local service.
     *
     * @return the my page local service
     */
    public com.arman.csb.theme.service.MyPageLocalService getMyPageLocalService() {
        return myPageLocalService;
    }

    /**
     * Sets the my page local service.
     *
     * @param myPageLocalService the my page local service
     */
    public void setMyPageLocalService(
        com.arman.csb.theme.service.MyPageLocalService myPageLocalService) {
        this.myPageLocalService = myPageLocalService;
    }

    /**
     * Returns the my page remote service.
     *
     * @return the my page remote service
     */
    public com.arman.csb.theme.service.MyPageService getMyPageService() {
        return myPageService;
    }

    /**
     * Sets the my page remote service.
     *
     * @param myPageService the my page remote service
     */
    public void setMyPageService(
        com.arman.csb.theme.service.MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    /**
     * Returns the template local service.
     *
     * @return the template local service
     */
    public com.arman.csb.theme.service.TemplateLocalService getTemplateLocalService() {
        return templateLocalService;
    }

    /**
     * Sets the template local service.
     *
     * @param templateLocalService the template local service
     */
    public void setTemplateLocalService(
        com.arman.csb.theme.service.TemplateLocalService templateLocalService) {
        this.templateLocalService = templateLocalService;
    }

    /**
     * Returns the template remote service.
     *
     * @return the template remote service
     */
    public com.arman.csb.theme.service.TemplateService getTemplateService() {
        return templateService;
    }

    /**
     * Sets the template remote service.
     *
     * @param templateService the template remote service
     */
    public void setTemplateService(
        com.arman.csb.theme.service.TemplateService templateService) {
        this.templateService = templateService;
    }

    /**
     * Returns the template persistence.
     *
     * @return the template persistence
     */
    public TemplatePersistence getTemplatePersistence() {
        return templatePersistence;
    }

    /**
     * Sets the template persistence.
     *
     * @param templatePersistence the template persistence
     */
    public void setTemplatePersistence(TemplatePersistence templatePersistence) {
        this.templatePersistence = templatePersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return ContentHolder.class;
    }

    protected String getModelClassName() {
        return ContentHolder.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = contentHolderPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
