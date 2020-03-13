package com.demo.response;

import java.util.List;

import com.demo.vo.TicketVO;

public class TicketResponseObject {

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
	public List<TicketVO> getTicketVOList() {
		return ticketVOList;
	}
	public void setTicketVOList(List<TicketVO> ticketVOList) {
		this.ticketVOList = ticketVOList;
	}
	public TicketVO getTicketVo() {
		return ticketVo;
	}
	public void setTicketVo(TicketVO ticketVo) {
		this.ticketVo = ticketVo;
	}
	String failureMessage;
	List<TicketVO> ticketVOList;
	TicketVO ticketVo;
}
