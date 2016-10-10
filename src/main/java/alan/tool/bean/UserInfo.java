/**
 * 
 */
package alan.tool.bean;

/**
 * @author WangHui
 *
 * 2016年9月7日
 */
public class UserInfo {
	 private Long id;

	    private String termid;

	    private String billid;

	    private String impwd;

	    private String ext1;

	    private String ext2;

	    private String ext3;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getTermid() {
	        return termid;
	    }

	    public void setTermid(String termid) {
	        this.termid = termid == null ? null : termid.trim();
	    }

	    public String getBillid() {
	        return billid;
	    }

	    public void setBillid(String billid) {
	        this.billid = billid == null ? null : billid.trim();
	    }

	    public String getImpwd() {
	        return impwd;
	    }

	    public void setImpwd(String impwd) {
	        this.impwd = impwd == null ? null : impwd.trim();
	    }

	    public String getExt1() {
	        return ext1;
	    }

	    public void setExt1(String ext1) {
	        this.ext1 = ext1 == null ? null : ext1.trim();
	    }

	    public String getExt2() {
	        return ext2;
	    }

	    public void setExt2(String ext2) {
	        this.ext2 = ext2 == null ? null : ext2.trim();
	    }

	    public String getExt3() {
	        return ext3;
	    }

	    public void setExt3(String ext3) {
	        this.ext3 = ext3 == null ? null : ext3.trim();
	    }
}
