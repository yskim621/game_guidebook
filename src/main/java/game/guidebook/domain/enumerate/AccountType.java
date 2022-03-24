package game.guidebook.domain.enumerate;

/**
 * zhanghaoleixin
 * @ClassName: AccountType
 * @author zhong
 * @date 2016-5-23 4:59:35
 */
public enum AccountType
{

	COMMON("공",0),

	PRIVATE("사",1);

	private String text;
	private  String localCode;
	AccountType(String text,int index)
	{
		this.text = text;
		this.localCode=getClass().getSimpleName()+index;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

}
