package com.arman.csb.theme.model.impl;

import com.arman.csb.theme.model.Template;
import com.arman.csb.theme.model.TemplateModel;
import com.arman.csb.theme.model.TemplateSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Template service. Represents a row in the &quot;CSB_Template&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.arman.csb.theme.model.TemplateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TemplateImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TemplateImpl
 * @see com.arman.csb.theme.model.Template
 * @see com.arman.csb.theme.model.TemplateModel
 * @generated
 */
@JSON(strict = true)
public class TemplateModelImpl extends BaseModelImpl<Template>
    implements TemplateModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a template model instance should use the {@link com.arman.csb.theme.model.Template} interface instead.
     */
    public static final String TABLE_NAME = "CSB_Template";
    public static final Object[][] TABLE_COLUMNS = {
            { "uuid_", Types.VARCHAR },
            { "id_", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP },
            { "name", Types.VARCHAR },
            { "head", Types.VARCHAR },
            { "bottom", Types.VARCHAR },
            { "htmlContent", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table CSB_Template (uuid_ VARCHAR(75) null,id_ LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,head VARCHAR(75) null,bottom VARCHAR(75) null,htmlContent VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table CSB_Template";
    public static final String ORDER_BY_JPQL = " ORDER BY template.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY CSB_Template.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.arman.csb.theme.model.Template"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.arman.csb.theme.model.Template"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.arman.csb.theme.model.Template"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long GROUPID_COLUMN_BITMASK = 2L;
    public static long UUID_COLUMN_BITMASK = 4L;
    public static long ID_COLUMN_BITMASK = 8L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.arman.csb.theme.model.Template"));
    private static ClassLoader _classLoader = Template.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            Template.class
        };
    private String _uuid;
    private String _originalUuid;
    private long _id;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _head;
    private String _bottom;
    private String _htmlContent;
    private long _columnBitmask;
    private Template _escapedModel;

    public TemplateModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Template toModel(TemplateSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Template model = new TemplateImpl();

        model.setUuid(soapModel.getUuid());
        model.setId(soapModel.getId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());
        model.setName(soapModel.getName());
        model.setHead(soapModel.getHead());
        model.setBottom(soapModel.getBottom());
        model.setHtmlContent(soapModel.getHtmlContent());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Template> toModels(TemplateSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Template> models = new ArrayList<Template>(soapModels.length);

        for (TemplateSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Template.class;
    }

    @Override
    public String getModelClassName() {
        return Template.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("id", getId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("head", getHead());
        attributes.put("bottom", getBottom());
        attributes.put("htmlContent", getHtmlContent());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String head = (String) attributes.get("head");

        if (head != null) {
            setHead(head);
        }

        String bottom = (String) attributes.get("bottom");

        if (bottom != null) {
            setBottom(bottom);
        }

        String htmlContent = (String) attributes.get("htmlContent");

        if (htmlContent != null) {
            setHtmlContent(htmlContent);
        }
    }

    @JSON
    @Override
    public String getUuid() {
        if (_uuid == null) {
            return StringPool.BLANK;
        } else {
            return _uuid;
        }
    }

    @Override
    public void setUuid(String uuid) {
        if (_originalUuid == null) {
            _originalUuid = _uuid;
        }

        _uuid = uuid;
    }

    public String getOriginalUuid() {
        return GetterUtil.getString(_originalUuid);
    }

    @JSON
    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;
    }

    @JSON
    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _columnBitmask |= GROUPID_COLUMN_BITMASK;

        if (!_setOriginalGroupId) {
            _setOriginalGroupId = true;

            _originalGroupId = _groupId;
        }

        _groupId = groupId;
    }

    public long getOriginalGroupId() {
        return _originalGroupId;
    }

    @JSON
    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _columnBitmask |= COMPANYID_COLUMN_BITMASK;

        if (!_setOriginalCompanyId) {
            _setOriginalCompanyId = true;

            _originalCompanyId = _companyId;
        }

        _companyId = companyId;
    }

    public long getOriginalCompanyId() {
        return _originalCompanyId;
    }

    @JSON
    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @JSON
    @Override
    public String getUserName() {
        if (_userName == null) {
            return StringPool.BLANK;
        } else {
            return _userName;
        }
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;
    }

    @JSON
    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @JSON
    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    @JSON
    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @JSON
    @Override
    public String getHead() {
        if (_head == null) {
            return StringPool.BLANK;
        } else {
            return _head;
        }
    }

    @Override
    public void setHead(String head) {
        _head = head;
    }

    @JSON
    @Override
    public String getBottom() {
        if (_bottom == null) {
            return StringPool.BLANK;
        } else {
            return _bottom;
        }
    }

    @Override
    public void setBottom(String bottom) {
        _bottom = bottom;
    }

    @JSON
    @Override
    public String getHtmlContent() {
        if (_htmlContent == null) {
            return StringPool.BLANK;
        } else {
            return _htmlContent;
        }
    }

    @Override
    public void setHtmlContent(String htmlContent) {
        _htmlContent = htmlContent;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Template.class.getName()));
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            Template.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Template toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Template) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        TemplateImpl templateImpl = new TemplateImpl();

        templateImpl.setUuid(getUuid());
        templateImpl.setId(getId());
        templateImpl.setGroupId(getGroupId());
        templateImpl.setCompanyId(getCompanyId());
        templateImpl.setUserId(getUserId());
        templateImpl.setUserName(getUserName());
        templateImpl.setCreateDate(getCreateDate());
        templateImpl.setModifiedDate(getModifiedDate());
        templateImpl.setName(getName());
        templateImpl.setHead(getHead());
        templateImpl.setBottom(getBottom());
        templateImpl.setHtmlContent(getHtmlContent());

        templateImpl.resetOriginalValues();

        return templateImpl;
    }

    @Override
    public int compareTo(Template template) {
        long primaryKey = template.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Template)) {
            return false;
        }

        Template template = (Template) obj;

        long primaryKey = template.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        TemplateModelImpl templateModelImpl = this;

        templateModelImpl._originalUuid = templateModelImpl._uuid;

        templateModelImpl._originalGroupId = templateModelImpl._groupId;

        templateModelImpl._setOriginalGroupId = false;

        templateModelImpl._originalCompanyId = templateModelImpl._companyId;

        templateModelImpl._setOriginalCompanyId = false;

        templateModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Template> toCacheModel() {
        TemplateCacheModel templateCacheModel = new TemplateCacheModel();

        templateCacheModel.uuid = getUuid();

        String uuid = templateCacheModel.uuid;

        if ((uuid != null) && (uuid.length() == 0)) {
            templateCacheModel.uuid = null;
        }

        templateCacheModel.id = getId();

        templateCacheModel.groupId = getGroupId();

        templateCacheModel.companyId = getCompanyId();

        templateCacheModel.userId = getUserId();

        templateCacheModel.userName = getUserName();

        String userName = templateCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            templateCacheModel.userName = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            templateCacheModel.createDate = createDate.getTime();
        } else {
            templateCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            templateCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            templateCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        templateCacheModel.name = getName();

        String name = templateCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            templateCacheModel.name = null;
        }

        templateCacheModel.head = getHead();

        String head = templateCacheModel.head;

        if ((head != null) && (head.length() == 0)) {
            templateCacheModel.head = null;
        }

        templateCacheModel.bottom = getBottom();

        String bottom = templateCacheModel.bottom;

        if ((bottom != null) && (bottom.length() == 0)) {
            templateCacheModel.bottom = null;
        }

        templateCacheModel.htmlContent = getHtmlContent();

        String htmlContent = templateCacheModel.htmlContent;

        if ((htmlContent != null) && (htmlContent.length() == 0)) {
            templateCacheModel.htmlContent = null;
        }

        return templateCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", id=");
        sb.append(getId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", head=");
        sb.append(getHead());
        sb.append(", bottom=");
        sb.append(getBottom());
        sb.append(", htmlContent=");
        sb.append(getHtmlContent());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append("com.arman.csb.theme.model.Template");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>head</column-name><column-value><![CDATA[");
        sb.append(getHead());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>bottom</column-name><column-value><![CDATA[");
        sb.append(getBottom());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>htmlContent</column-name><column-value><![CDATA[");
        sb.append(getHtmlContent());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}