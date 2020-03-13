package com.demo.response;

import java.util.List;

import com.demo.vo.DestinationVO;

public class DestinationResponseObject {
	
		String successMessage;                                                        
		public String getSuccessMessage() {
			return successMessage;
		}
		public void setSuccessMessage(String successMessage) {
			this.successMessage = successMessage;
		}
		public String getFailureMessage() {
			return failureMessage;
		}
		public void setFailureMessage(String failureMessage) {
			this.failureMessage = failureMessage;
		}
		public List<DestinationVO> getDestinationVOList() {
			return destinationVOList;
		}
		public void setDestinationVOList(List<DestinationVO> destinationVOList) {
			this.destinationVOList = destinationVOList;
		}
		public DestinationVO getDestinationVo() {
			return destinationVo;
		}
		public void setDestinationVo(DestinationVO destinationVo) {
			this.destinationVo = destinationVo;
		}
		String failureMessage;
		         List<DestinationVO> destinationVOList;
		         DestinationVO destinationVo;
}
