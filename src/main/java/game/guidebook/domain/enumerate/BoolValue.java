package game.guidebook.domain.enumerate;

/**
 * <pre>
 * 通用的枚举유형(是,否)
 * </pre>
 * @author zhaojitao
 * @version 1.0, 2010-7-19
 */
public enum BoolValue
{
	/**
	 * 是
	 */
	YES("예", true),
	/**
	 * 否
	 */
	NO("아니오", false);

	private String text;

	private Boolean value;

	BoolValue(String text, Boolean value)
	{
		this.text = text;
		this.value = value;
	}

	public String getText()
	{
		return text;
	}

	public Boolean getValue()
	{
		return value;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public void setValue(Boolean value)
	{
		this.value = value;
	}

	public static BoolValue valueOf(boolean value)
	{
		if (value)
		{
			return BoolValue.YES;
		}
		else
		{
			return BoolValue.NO;
		}
	}
}
