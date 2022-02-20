/**
 * <pre>
 * Title: 		AbstractEntity.java
 * Author:		zhaojitao
 * Create:	 	2010-7-6 上午11:40:21
 * Copyright: 	Copyright (c) 2010
 * Company:		Shenzhen Helper
 * <pre>
 */
package game.common.persist.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * <pre>
 * 基类
 * </pre>
 * @author zhaojitao
 * @version 1.0, 2015-5-6
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
//@EntityListeners(OperateLogListener.class)
public abstract class AbstractEntity implements Serializable
{
	private static final long serialVersionUID = 6757814772463743205L;

	@Column(nullable = false)
	private Long version = 0L;

	public abstract Object getId();

	public Long getVersion()
	{
		return version;
	}

	public void setVersion(Long version)
	{
		this.version = version;
	}

	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
