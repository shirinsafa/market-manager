package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.model.Instance;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InstancePersistenceImpl
 * @see InstanceUtil
 * @generated
 */
public interface InstancePersistence extends BasePersistence<Instance> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link InstanceUtil} to access the instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the instances where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the instances where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of instances
    * @param end the upper bound of the range of instances (not inclusive)
    * @return the range of matching instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the instances where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of instances
    * @param end the upper bound of the range of instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first instance in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first instance in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching instance, or <code>null</code> if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last instance in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last instance in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching instance, or <code>null</code> if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the instances before and after the current instance in the ordered set where uuid = &#63;.
    *
    * @param id the primary key of the current instance
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a instance with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the instances where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of instances where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching instances
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the instance where uuid = &#63; and groupId = &#63; or throws a {@link com.arman.csb.modules.NoSuchInstanceException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching instance, or <code>null</code> if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the instance where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching instance, or <code>null</code> if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the instance where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the instance that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of instances where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching instances
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the instances where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the instances where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of instances
    * @param end the upper bound of the range of instances (not inclusive)
    * @return the range of matching instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the instances where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of instances
    * @param end the upper bound of the range of instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first instance in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first instance in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching instance, or <code>null</code> if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last instance in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last instance in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching instance, or <code>null</code> if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the instances before and after the current instance in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param id the primary key of the current instance
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a instance with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance[] findByUuid_C_PrevAndNext(
        long id, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the instances where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of instances where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching instances
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the instances where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findByUserId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the instances where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of instances
    * @param end the upper bound of the range of instances (not inclusive)
    * @return the range of matching instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findByUserId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the instances where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of instances
    * @param end the upper bound of the range of instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findByUserId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first instance in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance findByUserId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first instance in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching instance, or <code>null</code> if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance fetchByUserId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last instance in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance findByUserId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last instance in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching instance, or <code>null</code> if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance fetchByUserId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the instances before and after the current instance in the ordered set where groupId = &#63;.
    *
    * @param id the primary key of the current instance
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a instance with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance[] findByUserId_PrevAndNext(
        long id, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the instances where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of instances where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching instances
    * @throws SystemException if a system exception occurred
    */
    public int countByUserId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the instances where name = &#63;.
    *
    * @param name the name
    * @return the matching instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the instances where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of instances
    * @param end the upper bound of the range of instances (not inclusive)
    * @return the range of matching instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findByName(
        java.lang.String name, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the instances where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of instances
    * @param end the upper bound of the range of instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findByName(
        java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first instance in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance findByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first instance in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching instance, or <code>null</code> if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance fetchByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last instance in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance findByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last instance in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching instance, or <code>null</code> if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance fetchByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the instances before and after the current instance in the ordered set where name = &#63;.
    *
    * @param id the primary key of the current instance
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a instance with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance[] findByName_PrevAndNext(
        long id, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the instances where name = &#63; from the database.
    *
    * @param name the name
    * @throws SystemException if a system exception occurred
    */
    public void removeByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of instances where name = &#63;.
    *
    * @param name the name
    * @return the number of matching instances
    * @throws SystemException if a system exception occurred
    */
    public int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the instance where groupId = &#63; or throws a {@link com.arman.csb.modules.NoSuchInstanceException} if it could not be found.
    *
    * @param groupId the group ID
    * @return the matching instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance findByGroupId(long groupId)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the instance where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param groupId the group ID
    * @return the matching instance, or <code>null</code> if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance fetchByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the instance where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching instance, or <code>null</code> if a matching instance could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance fetchByGroupId(long groupId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the instance where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @return the instance that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance removeByGroupId(long groupId)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of instances where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching instances
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the instance in the entity cache if it is enabled.
    *
    * @param instance the instance
    */
    public void cacheResult(com.arman.csb.modules.model.Instance instance);

    /**
    * Caches the instances in the entity cache if it is enabled.
    *
    * @param instances the instances
    */
    public void cacheResult(
        java.util.List<com.arman.csb.modules.model.Instance> instances);

    /**
    * Creates a new instance with the primary key. Does not add the instance to the database.
    *
    * @param id the primary key for the new instance
    * @return the new instance
    */
    public com.arman.csb.modules.model.Instance create(long id);

    /**
    * Removes the instance with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the instance
    * @return the instance that was removed
    * @throws com.arman.csb.modules.NoSuchInstanceException if a instance with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance remove(long id)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arman.csb.modules.model.Instance updateImpl(
        com.arman.csb.modules.model.Instance instance)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the instance with the primary key or throws a {@link com.arman.csb.modules.NoSuchInstanceException} if it could not be found.
    *
    * @param id the primary key of the instance
    * @return the instance
    * @throws com.arman.csb.modules.NoSuchInstanceException if a instance with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance findByPrimaryKey(long id)
        throws com.arman.csb.modules.NoSuchInstanceException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the instance with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the instance
    * @return the instance, or <code>null</code> if a instance with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arman.csb.modules.model.Instance fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the instances.
    *
    * @return the instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the instances.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of instances
    * @param end the upper bound of the range of instances (not inclusive)
    * @return the range of instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the instances.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of instances
    * @param end the upper bound of the range of instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of instances
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arman.csb.modules.model.Instance> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the instances from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of instances.
    *
    * @return the number of instances
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
