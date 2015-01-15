package com.arman.csb.modules.service.persistence;

import com.arman.csb.modules.NoSuchInvoiceItemException;
import com.arman.csb.modules.model.InvoiceItem;
import com.arman.csb.modules.model.impl.InvoiceItemImpl;
import com.arman.csb.modules.model.impl.InvoiceItemModelImpl;
import com.arman.csb.modules.service.persistence.InvoiceItemPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the invoice item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceItemPersistence
 * @see InvoiceItemUtil
 * @generated
 */
public class InvoiceItemPersistenceImpl extends BasePersistenceImpl<InvoiceItem>
    implements InvoiceItemPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link InvoiceItemUtil} to access the invoice item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = InvoiceItemImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
            InvoiceItemModelImpl.FINDER_CACHE_ENABLED, InvoiceItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
            InvoiceItemModelImpl.FINDER_CACHE_ENABLED, InvoiceItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
            InvoiceItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
            InvoiceItemModelImpl.FINDER_CACHE_ENABLED, InvoiceItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
            InvoiceItemModelImpl.FINDER_CACHE_ENABLED, InvoiceItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            InvoiceItemModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
            InvoiceItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "invoiceItem.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "invoiceItem.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(invoiceItem.uuid IS NULL OR invoiceItem.uuid = '')";
    public static final FinderPath FINDER_PATH_FETCH_BY_INVOICEID = new FinderPath(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
            InvoiceItemModelImpl.FINDER_CACHE_ENABLED, InvoiceItemImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByInvoiceId",
            new String[] { Long.class.getName() },
            InvoiceItemModelImpl.INVOICEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_INVOICEID = new FinderPath(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
            InvoiceItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInvoiceId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_INVOICEID_INVOICEID_2 = "invoiceItem.invoiceId = ?";
    private static final String _SQL_SELECT_INVOICEITEM = "SELECT invoiceItem FROM InvoiceItem invoiceItem";
    private static final String _SQL_SELECT_INVOICEITEM_WHERE = "SELECT invoiceItem FROM InvoiceItem invoiceItem WHERE ";
    private static final String _SQL_COUNT_INVOICEITEM = "SELECT COUNT(invoiceItem) FROM InvoiceItem invoiceItem";
    private static final String _SQL_COUNT_INVOICEITEM_WHERE = "SELECT COUNT(invoiceItem) FROM InvoiceItem invoiceItem WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "invoiceItem.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No InvoiceItem exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No InvoiceItem exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(InvoiceItemPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "uuid", "id", "number"
            });
    private static InvoiceItem _nullInvoiceItem = new InvoiceItemImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<InvoiceItem> toCacheModel() {
                return _nullInvoiceItemCacheModel;
            }
        };

    private static CacheModel<InvoiceItem> _nullInvoiceItemCacheModel = new CacheModel<InvoiceItem>() {
            @Override
            public InvoiceItem toEntityModel() {
                return _nullInvoiceItem;
            }
        };

    public InvoiceItemPersistenceImpl() {
        setModelClass(InvoiceItem.class);
    }

    /**
     * Returns all the invoice items where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching invoice items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<InvoiceItem> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the invoice items where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of invoice items
     * @param end the upper bound of the range of invoice items (not inclusive)
     * @return the range of matching invoice items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<InvoiceItem> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    /**
     * Returns an ordered range of all the invoice items where uuid = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param uuid the uuid
     * @param start the lower bound of the range of invoice items
     * @param end the upper bound of the range of invoice items (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching invoice items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<InvoiceItem> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<InvoiceItem> list = (List<InvoiceItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (InvoiceItem invoiceItem : list) {
                if (!Validator.equals(uuid, invoiceItem.getUuid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_INVOICEITEM_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(InvoiceItemModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                if (!pagination) {
                    list = (List<InvoiceItem>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<InvoiceItem>(list);
                } else {
                    list = (List<InvoiceItem>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first invoice item in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching invoice item
     * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a matching invoice item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchInvoiceItemException, SystemException {
        InvoiceItem invoiceItem = fetchByUuid_First(uuid, orderByComparator);

        if (invoiceItem != null) {
            return invoiceItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchInvoiceItemException(msg.toString());
    }

    /**
     * Returns the first invoice item in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching invoice item, or <code>null</code> if a matching invoice item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem fetchByUuid_First(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        List<InvoiceItem> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last invoice item in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching invoice item
     * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a matching invoice item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem findByUuid_Last(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchInvoiceItemException, SystemException {
        InvoiceItem invoiceItem = fetchByUuid_Last(uuid, orderByComparator);

        if (invoiceItem != null) {
            return invoiceItem;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("uuid=");
        msg.append(uuid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchInvoiceItemException(msg.toString());
    }

    /**
     * Returns the last invoice item in the ordered set where uuid = &#63;.
     *
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching invoice item, or <code>null</code> if a matching invoice item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem fetchByUuid_Last(String uuid,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUuid(uuid);

        if (count == 0) {
            return null;
        }

        List<InvoiceItem> list = findByUuid(uuid, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the invoice items before and after the current invoice item in the ordered set where uuid = &#63;.
     *
     * @param id the primary key of the current invoice item
     * @param uuid the uuid
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next invoice item
     * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a invoice item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem[] findByUuid_PrevAndNext(long id, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchInvoiceItemException, SystemException {
        InvoiceItem invoiceItem = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            InvoiceItem[] array = new InvoiceItemImpl[3];

            array[0] = getByUuid_PrevAndNext(session, invoiceItem, uuid,
                    orderByComparator, true);

            array[1] = invoiceItem;

            array[2] = getByUuid_PrevAndNext(session, invoiceItem, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected InvoiceItem getByUuid_PrevAndNext(Session session,
        InvoiceItem invoiceItem, String uuid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_INVOICEITEM_WHERE);

        boolean bindUuid = false;

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else if (uuid.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_UUID_UUID_3);
        } else {
            bindUuid = true;

            query.append(_FINDER_COLUMN_UUID_UUID_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(InvoiceItemModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUuid) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(invoiceItem);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<InvoiceItem> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the invoice items where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUuid(String uuid) throws SystemException {
        for (InvoiceItem invoiceItem : findByUuid(uuid, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(invoiceItem);
        }
    }

    /**
     * Returns the number of invoice items where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching invoice items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUuid(String uuid) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_INVOICEITEM_WHERE);

            boolean bindUuid = false;

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                bindUuid = true;

                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUuid) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the invoice item where invoiceId = &#63; or throws a {@link com.arman.csb.modules.NoSuchInvoiceItemException} if it could not be found.
     *
     * @param invoiceId the invoice ID
     * @return the matching invoice item
     * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a matching invoice item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem findByInvoiceId(long invoiceId)
        throws NoSuchInvoiceItemException, SystemException {
        InvoiceItem invoiceItem = fetchByInvoiceId(invoiceId);

        if (invoiceItem == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("invoiceId=");
            msg.append(invoiceId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchInvoiceItemException(msg.toString());
        }

        return invoiceItem;
    }

    /**
     * Returns the invoice item where invoiceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param invoiceId the invoice ID
     * @return the matching invoice item, or <code>null</code> if a matching invoice item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem fetchByInvoiceId(long invoiceId)
        throws SystemException {
        return fetchByInvoiceId(invoiceId, true);
    }

    /**
     * Returns the invoice item where invoiceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param invoiceId the invoice ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching invoice item, or <code>null</code> if a matching invoice item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem fetchByInvoiceId(long invoiceId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { invoiceId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_INVOICEID,
                    finderArgs, this);
        }

        if (result instanceof InvoiceItem) {
            InvoiceItem invoiceItem = (InvoiceItem) result;

            if ((invoiceId != invoiceItem.getInvoiceId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_INVOICEITEM_WHERE);

            query.append(_FINDER_COLUMN_INVOICEID_INVOICEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(invoiceId);

                List<InvoiceItem> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVOICEID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "InvoiceItemPersistenceImpl.fetchByInvoiceId(long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    InvoiceItem invoiceItem = list.get(0);

                    result = invoiceItem;

                    cacheResult(invoiceItem);

                    if ((invoiceItem.getInvoiceId() != invoiceId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVOICEID,
                            finderArgs, invoiceItem);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INVOICEID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (InvoiceItem) result;
        }
    }

    /**
     * Removes the invoice item where invoiceId = &#63; from the database.
     *
     * @param invoiceId the invoice ID
     * @return the invoice item that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem removeByInvoiceId(long invoiceId)
        throws NoSuchInvoiceItemException, SystemException {
        InvoiceItem invoiceItem = findByInvoiceId(invoiceId);

        return remove(invoiceItem);
    }

    /**
     * Returns the number of invoice items where invoiceId = &#63;.
     *
     * @param invoiceId the invoice ID
     * @return the number of matching invoice items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByInvoiceId(long invoiceId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_INVOICEID;

        Object[] finderArgs = new Object[] { invoiceId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_INVOICEITEM_WHERE);

            query.append(_FINDER_COLUMN_INVOICEID_INVOICEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(invoiceId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the invoice item in the entity cache if it is enabled.
     *
     * @param invoiceItem the invoice item
     */
    @Override
    public void cacheResult(InvoiceItem invoiceItem) {
        EntityCacheUtil.putResult(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
            InvoiceItemImpl.class, invoiceItem.getPrimaryKey(), invoiceItem);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVOICEID,
            new Object[] { invoiceItem.getInvoiceId() }, invoiceItem);

        invoiceItem.resetOriginalValues();
    }

    /**
     * Caches the invoice items in the entity cache if it is enabled.
     *
     * @param invoiceItems the invoice items
     */
    @Override
    public void cacheResult(List<InvoiceItem> invoiceItems) {
        for (InvoiceItem invoiceItem : invoiceItems) {
            if (EntityCacheUtil.getResult(
                        InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
                        InvoiceItemImpl.class, invoiceItem.getPrimaryKey()) == null) {
                cacheResult(invoiceItem);
            } else {
                invoiceItem.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all invoice items.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(InvoiceItemImpl.class.getName());
        }

        EntityCacheUtil.clearCache(InvoiceItemImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the invoice item.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(InvoiceItem invoiceItem) {
        EntityCacheUtil.removeResult(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
            InvoiceItemImpl.class, invoiceItem.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(invoiceItem);
    }

    @Override
    public void clearCache(List<InvoiceItem> invoiceItems) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (InvoiceItem invoiceItem : invoiceItems) {
            EntityCacheUtil.removeResult(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
                InvoiceItemImpl.class, invoiceItem.getPrimaryKey());

            clearUniqueFindersCache(invoiceItem);
        }
    }

    protected void cacheUniqueFindersCache(InvoiceItem invoiceItem) {
        if (invoiceItem.isNew()) {
            Object[] args = new Object[] { invoiceItem.getInvoiceId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INVOICEID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVOICEID, args,
                invoiceItem);
        } else {
            InvoiceItemModelImpl invoiceItemModelImpl = (InvoiceItemModelImpl) invoiceItem;

            if ((invoiceItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_INVOICEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { invoiceItem.getInvoiceId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_INVOICEID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_INVOICEID, args,
                    invoiceItem);
            }
        }
    }

    protected void clearUniqueFindersCache(InvoiceItem invoiceItem) {
        InvoiceItemModelImpl invoiceItemModelImpl = (InvoiceItemModelImpl) invoiceItem;

        Object[] args = new Object[] { invoiceItem.getInvoiceId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INVOICEID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INVOICEID, args);

        if ((invoiceItemModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_INVOICEID.getColumnBitmask()) != 0) {
            args = new Object[] { invoiceItemModelImpl.getOriginalInvoiceId() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INVOICEID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_INVOICEID, args);
        }
    }

    /**
     * Creates a new invoice item with the primary key. Does not add the invoice item to the database.
     *
     * @param id the primary key for the new invoice item
     * @return the new invoice item
     */
    @Override
    public InvoiceItem create(long id) {
        InvoiceItem invoiceItem = new InvoiceItemImpl();

        invoiceItem.setNew(true);
        invoiceItem.setPrimaryKey(id);

        String uuid = PortalUUIDUtil.generate();

        invoiceItem.setUuid(uuid);

        return invoiceItem;
    }

    /**
     * Removes the invoice item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the invoice item
     * @return the invoice item that was removed
     * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a invoice item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem remove(long id)
        throws NoSuchInvoiceItemException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the invoice item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the invoice item
     * @return the invoice item that was removed
     * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a invoice item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem remove(Serializable primaryKey)
        throws NoSuchInvoiceItemException, SystemException {
        Session session = null;

        try {
            session = openSession();

            InvoiceItem invoiceItem = (InvoiceItem) session.get(InvoiceItemImpl.class,
                    primaryKey);

            if (invoiceItem == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchInvoiceItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(invoiceItem);
        } catch (NoSuchInvoiceItemException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected InvoiceItem removeImpl(InvoiceItem invoiceItem)
        throws SystemException {
        invoiceItem = toUnwrappedModel(invoiceItem);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(invoiceItem)) {
                invoiceItem = (InvoiceItem) session.get(InvoiceItemImpl.class,
                        invoiceItem.getPrimaryKeyObj());
            }

            if (invoiceItem != null) {
                session.delete(invoiceItem);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (invoiceItem != null) {
            clearCache(invoiceItem);
        }

        return invoiceItem;
    }

    @Override
    public InvoiceItem updateImpl(
        com.arman.csb.modules.model.InvoiceItem invoiceItem)
        throws SystemException {
        invoiceItem = toUnwrappedModel(invoiceItem);

        boolean isNew = invoiceItem.isNew();

        InvoiceItemModelImpl invoiceItemModelImpl = (InvoiceItemModelImpl) invoiceItem;

        if (Validator.isNull(invoiceItem.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            invoiceItem.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (invoiceItem.isNew()) {
                session.save(invoiceItem);

                invoiceItem.setNew(false);
            } else {
                session.merge(invoiceItem);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !InvoiceItemModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((invoiceItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        invoiceItemModelImpl.getOriginalUuid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { invoiceItemModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }
        }

        EntityCacheUtil.putResult(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
            InvoiceItemImpl.class, invoiceItem.getPrimaryKey(), invoiceItem);

        clearUniqueFindersCache(invoiceItem);
        cacheUniqueFindersCache(invoiceItem);

        return invoiceItem;
    }

    protected InvoiceItem toUnwrappedModel(InvoiceItem invoiceItem) {
        if (invoiceItem instanceof InvoiceItemImpl) {
            return invoiceItem;
        }

        InvoiceItemImpl invoiceItemImpl = new InvoiceItemImpl();

        invoiceItemImpl.setNew(invoiceItem.isNew());
        invoiceItemImpl.setPrimaryKey(invoiceItem.getPrimaryKey());

        invoiceItemImpl.setUuid(invoiceItem.getUuid());
        invoiceItemImpl.setId(invoiceItem.getId());
        invoiceItemImpl.setCreateDate(invoiceItem.getCreateDate());
        invoiceItemImpl.setModifiedDate(invoiceItem.getModifiedDate());
        invoiceItemImpl.setInvoiceId(invoiceItem.getInvoiceId());
        invoiceItemImpl.setProductCode(invoiceItem.getProductCode());
        invoiceItemImpl.setProductName(invoiceItem.getProductName());
        invoiceItemImpl.setNumber(invoiceItem.getNumber());
        invoiceItemImpl.setBasePrice(invoiceItem.getBasePrice());

        return invoiceItemImpl;
    }

    /**
     * Returns the invoice item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the invoice item
     * @return the invoice item
     * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a invoice item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem findByPrimaryKey(Serializable primaryKey)
        throws NoSuchInvoiceItemException, SystemException {
        InvoiceItem invoiceItem = fetchByPrimaryKey(primaryKey);

        if (invoiceItem == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchInvoiceItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return invoiceItem;
    }

    /**
     * Returns the invoice item with the primary key or throws a {@link com.arman.csb.modules.NoSuchInvoiceItemException} if it could not be found.
     *
     * @param id the primary key of the invoice item
     * @return the invoice item
     * @throws com.arman.csb.modules.NoSuchInvoiceItemException if a invoice item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem findByPrimaryKey(long id)
        throws NoSuchInvoiceItemException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the invoice item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the invoice item
     * @return the invoice item, or <code>null</code> if a invoice item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        InvoiceItem invoiceItem = (InvoiceItem) EntityCacheUtil.getResult(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
                InvoiceItemImpl.class, primaryKey);

        if (invoiceItem == _nullInvoiceItem) {
            return null;
        }

        if (invoiceItem == null) {
            Session session = null;

            try {
                session = openSession();

                invoiceItem = (InvoiceItem) session.get(InvoiceItemImpl.class,
                        primaryKey);

                if (invoiceItem != null) {
                    cacheResult(invoiceItem);
                } else {
                    EntityCacheUtil.putResult(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
                        InvoiceItemImpl.class, primaryKey, _nullInvoiceItem);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(InvoiceItemModelImpl.ENTITY_CACHE_ENABLED,
                    InvoiceItemImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return invoiceItem;
    }

    /**
     * Returns the invoice item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the invoice item
     * @return the invoice item, or <code>null</code> if a invoice item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public InvoiceItem fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the invoice items.
     *
     * @return the invoice items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<InvoiceItem> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the invoice items.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of invoice items
     * @param end the upper bound of the range of invoice items (not inclusive)
     * @return the range of invoice items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<InvoiceItem> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the invoice items.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arman.csb.modules.model.impl.InvoiceItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of invoice items
     * @param end the upper bound of the range of invoice items (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of invoice items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<InvoiceItem> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<InvoiceItem> list = (List<InvoiceItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_INVOICEITEM);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_INVOICEITEM;

                if (pagination) {
                    sql = sql.concat(InvoiceItemModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<InvoiceItem>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<InvoiceItem>(list);
                } else {
                    list = (List<InvoiceItem>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the invoice items from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (InvoiceItem invoiceItem : findAll()) {
            remove(invoiceItem);
        }
    }

    /**
     * Returns the number of invoice items.
     *
     * @return the number of invoice items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_INVOICEITEM);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the invoice item persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.arman.csb.modules.model.InvoiceItem")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<InvoiceItem>> listenersList = new ArrayList<ModelListener<InvoiceItem>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<InvoiceItem>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(InvoiceItemImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}