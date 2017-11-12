package me.brkn.raspberrydashboard.service.output;

import java.math.BigDecimal;

public class CpuUtilizationInfoServiceOutput {

	/**
	 * Average utilization of the CPU.
	 */
	private BigDecimal cpuAverage;

	/**
	 * Average utilization of the first core
	 */
	private BigDecimal core1;

	/**
	 * Average utilization of the second core
	 */
	private BigDecimal core2;

	/**
	 * Average utilization of the third core
	 */
	private BigDecimal core3;

	/**
	 * Average utilization of the forth core
	 */
	private BigDecimal core4;

	/**
	 * @return the cpuAverage
	 */
	public BigDecimal getCpuAverage() {
		return cpuAverage;
	}

	/**
	 * @param cpuAverage
	 *            the cpuAverage to set
	 */
	public void setCpuAverage(BigDecimal cpuAverage) {
		this.cpuAverage = cpuAverage;
	}

	/**
	 * @return the core1
	 */
	public BigDecimal getCore1() {
		return core1;
	}

	/**
	 * @param core1
	 *            the core1 to set
	 */
	public void setCore1(BigDecimal core1) {
		this.core1 = core1;
	}

	/**
	 * @return the core2
	 */
	public BigDecimal getCore2() {
		return core2;
	}

	/**
	 * @param core2
	 *            the core2 to set
	 */
	public void setCore2(BigDecimal core2) {
		this.core2 = core2;
	}

	/**
	 * @return the core3
	 */
	public BigDecimal getCore3() {
		return core3;
	}

	/**
	 * @param core3
	 *            the core3 to set
	 */
	public void setCore3(BigDecimal core3) {
		this.core3 = core3;
	}

	/**
	 * @return the core4
	 */
	public BigDecimal getCore4() {
		return core4;
	}

	/**
	 * @param core4
	 *            the core4 to set
	 */
	public void setCore4(BigDecimal core4) {
		this.core4 = core4;
	}

}
