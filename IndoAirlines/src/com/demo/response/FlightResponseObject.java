package com.demo.response;

import java.util.List;

import com.demo.vo.FlightVO;

public class FlightResponseObject {
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
			public List<FlightVO> getFlightList() {
				return FlightList;
			}
			public void setFlightList(List<FlightVO> flightList) {
				FlightList = flightList;
			}
			public FlightVO getFlightVO() {
				return flightVO;
			}
			public void setFlightVO(FlightVO flightVO) {
				this.flightVO = flightVO;
			}
		String failureMessage;
		         List<FlightVO> FlightList;
		         FlightVO flightVO;
}
