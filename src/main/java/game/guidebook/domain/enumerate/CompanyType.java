package game.guidebook.domain.enumerate;


/**
 * <pre>
 * 公司유형
 * </pre>
 * @author zhaojitao
 * @version 1.0, 2016-1-19
 */
public enum CompanyType
{
	/**
	 * 普通工厂
	 */
	NORMAL("일반공장");

	private String text;

	CompanyType(String text)
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
