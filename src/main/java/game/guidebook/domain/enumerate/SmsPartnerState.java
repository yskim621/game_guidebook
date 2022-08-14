package game.guidebook.domain.enumerate;

/**
 * <pre>
 * 合作商상태
 * </pre>
 * @author zhaojitao
 * @version 1.0, 2016-1-19
 */
public enum SmsPartnerState
{
	/**
	 * 닫기
	 */
	CLOSED("닫기"),
	/**
	 * 打开
	 */
	OPEN("열기");

	private String text;

	SmsPartnerState(String text)
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
