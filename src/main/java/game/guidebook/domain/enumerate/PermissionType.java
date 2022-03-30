package game.guidebook.domain.enumerate;

/**
 *
 * <pre>
 * 权限菜单类型
 * </pre>
 * @author zhaojt
 * @version 1.0, 2016年6月20日
 */
public enum PermissionType
{
	/**
	 * 菜单
	 */
	MENU("메뉴"),
	/**
	 * 功能
	 */
	FUNCTION("기능");
	private String text;

	PermissionType(String text)
	{
		this.text = text;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}
}
