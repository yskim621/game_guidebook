package game.common.persist.query;

import java.util.List;

/**
 * <pre>
 * 分页查询返回的结果集
 * </pre>
 * @author chenjian
 * @version 1.0, 2012-5-8
 */

public class SearchResult<T>
{
	/**
	 * 查询的记录集
	 */
	private List<T> result;

	/**
	 * 查询总行数
	 */
	private Integer count;

	public List<T> getResult()
	{
		return result;
	}

	public void setResult(List<T> result)
	{
		this.result = result;
	}

	public Integer getCount()
	{
		return count;
	}

	public void setCount(Integer count)
	{
		this.count = count;
	}

	@Override
	public String toString() {
		return "SearchResult{" +
				"result=" + result +
				", count=" + count +
				'}';
	}
}
