package game.guidebook.common;

import game.common.persist.entity.AbstractTableIdEntity;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * <pre>
 * 公司基础信息基类
 * </pre>
 * @author zhaojitao
 * @version 1.0, 2016-1-29
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseTableIdEntity extends AbstractTableIdEntity
{
	private static final long serialVersionUID = -9064495946832615405L;
}