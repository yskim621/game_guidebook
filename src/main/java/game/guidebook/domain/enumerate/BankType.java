package game.guidebook.domain.enumerate;

/**
 *
 * <pre>
 * yinhangliebiao
 * </pre>
 * @author zhaojt
 * @version 1.0, 2016-6-20
 */
public enum BankType
{

	ICBC("icbc", "국민은행", 1),

	ABC("abc", "기업은행", 2),

	BOC("boc", "농협", 3),

	CCB("ccb", "신한은행", 4),

	BCM("bcm", "한국스탠다드차타드은행", 5),

	CMB("cmb", "하나은행", 6),

	CMBC("cmbc", "한국씨티은행", 7),

	CCITICB("cciticb", "우리은행", 8),

	CIB("cib", "경남은행", 9),

	CEB("ceb", "광주은행", 10),

	PAB("pab", "대구은행", 11),

	PSBC("psbc", "도이치", 12),


	BOB("bjrcb", "부산은행", 21),

	GZCB("gzcb", "산업은행", 22),

	HZB("hzb", "수협", 23),

	NBCB("nbcb", "전북은행", 24),

	NJCB("njcb", "제주은행", 25),

	CBB("cbb", "새마을금고", 26),

	GDB("gdb", "신용협동조합", 27),

	SDB("sdb", "상호저축은행", 28),

	SPDB("spdb", "하나금융투자", 29),

	SRCB("srcb", "신한금융투자", 30),

	GZRCC("gdrcc", "유진투자증권", 31),


	CZB("czb", "부국증권", 51),

	HSB("hsb", "키움증권", 52),

	HXB("hxb", "대신증권", 53),

	BEA("bea", "동부증권", 54),

	OTHER("OTHER", "기타은행", 99);
	private String text;

	private String value;

	private int sort;

	BankType(String value, String text, int sort)
	{
		this.value = value;
		this.text = text;
		this.sort = sort;
	}

	public String getText()
	{
		return text;
	}

	public String getValue()
	{
		return value;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public void setValue(String value)
	{
		this.text = value;
	}

	public int getSort()
	{
		return sort;
	}

	public void setSort(int sort)
	{
		this.sort = sort;
	}
}
