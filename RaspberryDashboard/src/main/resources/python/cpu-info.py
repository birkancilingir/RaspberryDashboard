import psutil

def cpu_times(percpu=False):
    return psutil.cpu_times(percpu)

def cpu_percent
    return psutil.cpu_percent(interval=None, percpu=False)

def cpu_times_percent
    return psutil.cpu_times_percent(interval=None, percpu=False)

def cpu_count
    return psutil.cpu_count(logical=True)

def cpu_stats
    return psutil.cpu_stats()

def cpu_freq
    return psutil.cpu_freq(percpu=False)