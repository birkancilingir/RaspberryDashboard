package me.brkn.raspberrydashboard.python.result.item;

public class CpuTimesPythonResultItem {

	/**
	 * Time spent by normal processes executing in user mode; on Linux this also
	 * includes guest time
	 */
	private float user;

	/**
	 * Time spent by processes executing in kernel mode
	 */
	private float system;

	/**
	 * Time spent doing nothing
	 */
	private float idle;

	/**
	 * Time spent waiting for I/O to complete
	 */
	private float iowait;

	/**
	 * Time spent for servicing hardware interrupts
	 */
	private float irq;

	/**
	 * Time spent for servicing software interrupts
	 */
	private float softirq;

	/**
	 * Time spent by other operating systems running in a virtualized
	 * environment
	 */
	private float steal;

	/**
	 * Time spent running a virtual CPU for guest operating systems under the
	 * control of the Linux kernel
	 */
	private float guest;

	/**
	 * Time spent running a niced guest (virtual CPU for guest operating systems
	 * under the control of the Linux kernel)
	 */
	private float guetsNice;

	public float getUser() {
		return user;
	}

	public void setUser(float user) {
		this.user = user;
	}

	public float getSystem() {
		return system;
	}

	public void setSystem(float system) {
		this.system = system;
	}

	public float getIdle() {
		return idle;
	}

	public void setIdle(float idle) {
		this.idle = idle;
	}

	public float getIowait() {
		return iowait;
	}

	public void setIowait(float iowait) {
		this.iowait = iowait;
	}

	public float getIrq() {
		return irq;
	}

	public void setIrq(float irq) {
		this.irq = irq;
	}

	public float getSoftirq() {
		return softirq;
	}

	public void setSoftirq(float softirq) {
		this.softirq = softirq;
	}

	public float getSteal() {
		return steal;
	}

	public void setSteal(float steal) {
		this.steal = steal;
	}

	public float getGuest() {
		return guest;
	}

	public void setGuest(float guest) {
		this.guest = guest;
	}

	public float getGuetsNice() {
		return guetsNice;
	}

	public void setGuetsNice(float guetsNice) {
		this.guetsNice = guetsNice;
	}

}
