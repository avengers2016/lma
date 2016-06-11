/**
 * 
 */
package com.lma.exception;


/**
 * @author RAHUL
 *
 */
	public class ErrorResponse extends RuntimeException {

		
	private static final long serialVersionUID = -4685519800324205586L;
		private String errCode;
		private String errMsg;

		public String getErrCode() {
			return errCode;
		}

		public void setErrCode(String errCode) {
			this.errCode = errCode;
		}

		public String getErrMsg() {
			return errMsg;
		}

		public void setErrMsg(String errMsg) {
			this.errMsg = errMsg;
		}

		public ErrorResponse(String errCode, String errMsg) {
			this.errCode = errCode;
			this.errMsg = errMsg;
		}

		public ErrorResponse() {
			// TODO Auto-generated constructor stub
		}

	}

