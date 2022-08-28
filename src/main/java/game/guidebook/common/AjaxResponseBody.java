package game.guidebook.common;

import game.common.constant.Constant;

public class AjaxResponseBody
{
	/**
	 * 返回代码
	 */
	public String code;
	/**
	 * 返回对象
	 */
	public String message;
	
	/**
	 * 返回对象
	 */
	public Object obj;
	
	public boolean success;
	public AjaxResponseBody(String code)
	{
		super();
		this.code = code;
	}

	public AjaxResponseBody(String code, String message)
	{
		super();
		this.code = code;
		this.message = message;
	}

	public AjaxResponseBody(String code, String message, Object obj)
	{
		super();
		this.code = code;
		this.message = message;
		this.obj = obj;
	}
	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Object getObj()
	{
		return obj;
	}

	public void setObj(Object obj)
	{
		this.obj = obj;
	}

	public boolean isSuccess()
	{
		if(this.getCode().equals(Constant.TRANSACTION_RESPONSE_CODE_SUCCESS))
		{
			return true;
		}else{
			return false;
		}
		
	}
	
}
