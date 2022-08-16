package game.guidebook.service.dto;

import game.common.util.DateTimeUtil;
import game.guidebook.domain.enumerate.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * 列表查询参数reconcilTime
 * </pre>
 * @author zhaojt
 * @version 1.0, 2016年7月19日
 */
@Getter
@Setter
public class QueryParam implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ID
	private Long id;

	// 账户号
	private String bankNo;

	// 员工ID
	private Long employeeId;

	// 员工名称
	private String employeeName;

	// 仓库ID
	private Long warehouseId;
	
	// 仓库名称
	private String warehouseName;

	// 客户分类ID
	private Long customerClassId;

	// 客户分类名
	private String customerClassName;

	// 客户ID
	private Long customerId;

	// 客户名称
	private String customerName;

	// 客户单据编号
	private String customerBillNo;

	// 客户料号
	private String customerMaterialCode;

	// 是否期初
	private BoolValue isBegin;

	// 送货方式
	private String deliveryClassName;

	// 供应商分类ID
	private Long supplierClassId;

	// 供应商分类名称
	private String supplierClassName;

	// 供应商类型
	private SupplierType supplierType;

	// 供应商ID
	private Long supplierId;

	// 供应商名称
	private String supplierName;

	// 产品分类
	private Long productClassId;

	// 产品分类名
	private String productClassName;

	// 产品类型
	private ProductType productType;

	// 成品名称
	private String productName;
	
	//产品规格
	private String productStyle;
	
	//产品编号
	private String productCode;

	// 材料分类
	private Long materialClassId;

	// 材料分类名称
	private String materialClassName;

	// 材料类型
	private MaterialType materialType;

	// 材料名称
	private String materialName;

	private String materialCode;

	// 付款方式名称
	private String paymentClassName;

	// 发外类型
	private OutSourceType outSourceType;

	// 工序分类
	private Long procedureClassId;

	// 工序分类名称
	private String procedureClassName;

	// 工序类型
	private ProcedureType procedureType;

	// 工序名称
	private String procedureName;

	// 发料人
	private Long sendEmployeeId;

	// 领料人
	private Long receiveEmployeeId;

	// 调出仓库
	private Long outWarehouseId;

	// 调入仓库
	private Long inWarehouseId;

	// 销售单号
	private String saleBillNo;

	// 原单明细ID
	private Long sourceDetailId;

	// 工单号
	private String workBillNo;

	// 部门名称
	private String departmentName;

	// 公司名称
	private String companyName;

	// 是否正式
	private BoolValue isFormal;

	// 公司状态
	private CompanyState companyState;

	// 公司类型
	private CompanyType companyType;

	// 初始化进度
	private InitStep initStep;

	// 试用时间最小
	private Date expireTimeMin;

	// 使用时间最大
	private Date expireTimeMax;

	// 联系人姓名
	private String companyLinkName;

	// 公司电话
	private String companyTel;

	// 职位名称
	private String positionName;

	// 结算类型名称
	private String settlementClassName;

	// 税率名称
	private String taxRateName;

	// 单位名称
	private String unitName;

	// 系统公告标题
	private String noticeTitle;

	// 是否发布
	private BoolValue publish;
	//手机号码
	private String tel;
	//打印模板名称
	private PrintModleName printModleName;
	//机台名称
	private String machineName;
	/**
	 * 汇总年份
	 */
	private String year;

	/**
	 * 单据日期区间
	 */
	@DateTimeFormat(iso = ISO.DATE)
	private Date dateMin;

	@DateTimeFormat(iso = ISO.DATE)
	private Date dateMax;
	
	/**
	 * 修改日期区间
	 */
	@DateTimeFormat(iso = ISO.DATE)
	private Date udateMin;

	@DateTimeFormat(iso = ISO.DATE)
	private Date udateMax;

	/**
	 * 交货日期区间
	 */
	@DateTimeFormat(iso = ISO.DATE)
	private Date deliverDateMin;

	@DateTimeFormat(iso = ISO.DATE)
	private Date deliverDateMax;

	// 单据编号
	private String billNo;

	// 是否完工标志
	private BoolValue completeFlag;

	// 是否审核标志
	private BoolValue auditFlag;
	
	//是否取消
	private BoolValue isCancel;
	/**
	 * 是否显示0库存
	 */
	private BoolValue isEmptyWare;

	// 非固定字段查询条件
	private String searchContent;

	private Integer pageSize;

	private Integer pageNumber;

	private String title;
	//用户名
	private String userName;
	/**
	 * 留言类型
	 */
	private CommentType type;
	
	/**
	 * 报价类型
	 */
	private OfferType offerType;
	
	/**
	 * 分切类型
	 */
	private SplitType splitType;
	
	/**
	 * 材料规格
	 */
	private String specifications;
	
	private String name;
	
	private String code;
	
	/**
	 *
	 * 정렬을 위한 queryparam
	 */
	private String sortName;
	private String sortOrder;
	private String style;
	private Date deliveryTime;
	private Date qcTime;
	private String partName;
	private Date inTime;
	private Date checkTime;
	private Date lastTransTime;
	private Date createTime;
	private Date updateTime;
	private String updateName;
	private Date splitTime;
	private Date adjustTime;
	private String checkUserName;
	private String workNo;
	private BoolValue isOutSource;
	private AccountTransType transType;
	private FinanceTradeMode tradeMode;
	private String sourceBillType;
	private Date takeTime;
	private String branchName;
	private BankType bankType;
	private Date beginTime;
	private String brand;
	private String shortName;
	private ProduceType produceType;
	private String workPartStyle;
	private Integer splitQty;
	private String materialStyle;
	private String sourceBillNo;
	private Date reconcilTime;
	private String orderBillNo;
	private Date billTime;
	private String saleOrderBillNo;
	private Long materialId;
	private Date storageTime;
	private String linkName;
	private String receiveEmployeeName;
	private String sendEmployeeName;
	private Date returnTime;
	private String returnEmployeeName;
	private Date supplementTime;
	private Date outTime;
	private Date transferTime;
	private String adjustEmployeeName;
	private Date transTime;
	private String referenceId;

	//bom(계획서) sorting
	private String line;//라인
	private String orderNumber;//주문 번호
	private String isCanceled;//취소여부
	private String workOrder;// W/O
	private String modelSuffix;
	private String assyNo;
	private String workOrderDate; //주문일자
	private String needByDate; //납기일자
	private String pst; //생산 시작일자
	private String isNew;//원단위에 새로 등록된 날짜
	private String memo;
	private String isPackage;
	private String isPrint;
	private Long bomProduceId;//생산계획서id

	//bom_assy_datail(assy 하위 품목)
	private String itemLevel;
	private String itemType;
	private String partNo;
	private String itemDesc;
	private String itemSpec;
	private String revision;
	private String supplyType;
	private String itemStatus;
	private String componentQty;
	private String extendedQty;
	private String uom;
	private String effectiveDate;
	private String endDate;
	private String svcCode;
	private String ecoNo;
	private String parentPartNo;
	private String substituteItem;
	private String location;
	private String comments;
	private String maker;

	// bom_produce - 원단위 생산 계획서 조회
	private String createName;
	private String assyNoSingle;

	// barcode Read 여부
	private BoolValue isRead;
	private BoolValue isReadAll;

	private String userNickname;
	private Long userId;
	private String searchType;
	private String value;

	public Date getDateMin()
	{
		if (dateMin != null)
		{
			return DateTimeUtil.formatToDate(DateTimeUtil.formatShortStr(dateMin) + " 00:00:01",
					DateTimeUtil.DATE_FORMAT_YMDHMS);
		}
		return dateMin;
	}

	public void setDateMin(Date dateMin)
	{

		this.dateMin = dateMin;
	}

	public Date getDateMax()
	{
		if (dateMax != null)
		{
			return DateTimeUtil.formatToDate(DateTimeUtil.formatShortStr(dateMax) + " 23:59:59",
					DateTimeUtil.DATE_FORMAT_YMDHMS);
		}
		return dateMax;
	}

	public void setDateMax(Date dateMax)
	{
		this.dateMax = dateMax;
	}
	
	public Date getUdateMin()
	{
		if (udateMin != null)
		{
			return DateTimeUtil.formatToDate(DateTimeUtil.formatShortStr(udateMin) + " 00:00:00",
					DateTimeUtil.DATE_FORMAT_YMDHMS);
		}
		return udateMin;
	}

	public void setUdateMin(Date udateMin)
	{

		this.udateMin = udateMin;
	}

	public Date getUdateMax()
	{
		if (udateMax != null)
		{
			return DateTimeUtil.formatToDate(DateTimeUtil.formatShortStr(udateMax) + " 23:59:59",
					DateTimeUtil.DATE_FORMAT_YMDHMS);
		}
		return udateMax;
	}

	public Date getDeliverDateMax()
	{
		if (deliverDateMax != null)
		{
			return new Date(DateTimeUtil.addDate(deliverDateMax, 1).getTime() - 1);
		}
		return deliverDateMax;
	}

	public Date getExpireTimeMin()
	{
		if (expireTimeMin != null)
		{
			return DateTimeUtil.formatToDate(DateTimeUtil.formatShortStr(expireTimeMin) + " 00:00:00",
					DateTimeUtil.DATE_FORMAT_YMDHMS);
		}
		return expireTimeMin;
	}

	public void setExpireTimeMin(Date expireTimeMin)
	{
		this.expireTimeMin = expireTimeMin;
	}

	public Date getExpireTimeMax()
	{
		if (expireTimeMax != null)
		{
			return DateTimeUtil.formatToDate(DateTimeUtil.formatShortStr(expireTimeMax) + " 23:59:59",
					DateTimeUtil.DATE_FORMAT_YMDHMS);
		}
		return expireTimeMax;
	}


}
