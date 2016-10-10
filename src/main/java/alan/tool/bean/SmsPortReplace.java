package alan.tool.bean;

import java.io.Serializable;

/**
 * 通过渠道chanId 进行端口替换
 * @author WangHui
 *
 * 2016年3月30日
 */
public class SmsPortReplace implements Serializable{

	private static final long serialVersionUID = -1913512293176174308L;

	private int id;
	/**
	 * 接入方渠道标识
	 */
	private String chanId;
	/**
	 * 接入方、模板使用端口（待替换端口）
	 */
	private String portNum;
	/**
	 * 转换之后的端口
	 */
	private String replacedNum;
	private String status;
	private String remarks;
	private String replProvince;
	private String replType;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChanId() {
		return chanId;
	}
	public void setChanId(String chanId) {
		this.chanId = chanId;
	}
	public String getPortNum() {
		return portNum;
	}
	public void setPortNum(String portNum) {
		this.portNum = portNum;
	}
	public String getReplacedNum() {
		return replacedNum;
	}
	public void setReplacedNum(String replacedNum) {
		this.replacedNum = replacedNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	public String getReplProvince() {
		return replProvince;
	}
	public void setReplProvince(String replProvince) {
		this.replProvince = replProvince;
	}
	public String getReplType() {
		return replType;
	}
	public void setReplType(String replType) {
		this.replType = replType;
	}
	@Override
	public String toString() {
		return "SmsPortReplace [id=" + id + ", chanId=" + chanId + ", portNum=" + portNum + ", replacedNum=" + replacedNum + ", status=" + status
				+ ", remarks=" + remarks + ", replProvince=" + replProvince + ", replType=" + replType + "]";
	}
	public SmsPortReplace() {
		super();
	}
	
	
}
