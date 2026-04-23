import time
import random
import csv
from datetime import datetime

PRESSURE_WARNING    = 16.0
PRESSURE_DANGER     = 18.5
DISPLACEMENT_WARNING = 5.0
DISPLACEMENT_DANGER  = 10.0

LOG_FILE = "mine_sensor_log.csv"

def get_alert(pressure, displacement):
    if pressure >= PRESSURE_DANGER or displacement >= DISPLACEMENT_DANGER:
        return "DANGER"
    elif pressure >= PRESSURE_WARNING or displacement >= DISPLACEMENT_WARNING:
        return "WARNING"
    return "SAFE"

def simulate_reading(step):
    s = step % 25
    noise_p = random.uniform(-0.3, 0.3)
    noise_d = random.uniform(-0.2, 0.2)

    if s < 10:       # SAFE phase
        p = 10.0 + s * 0.5 + noise_p
        d = 1.0  + s * 0.2 + noise_d

    elif s < 15:     # WARNING phase
        p = 15.0 + (s - 10) * 0.5 + noise_p
        d = 4.5  + (s - 10) * 0.4 + noise_d

    elif s < 20:     # DANGER phase
        p = 18.0 + (s - 15) * 0.3 + noise_p
        d = 10.5 + (s - 15) * 0.3 + noise_d

    else:            # RECOVERY phase
        p = 19.0 - (s - 20) * 2.0 + noise_p
        d = 11.0 - (s - 20) * 2.0 + noise_d

    return round(max(0, p), 2), round(max(0, d), 2)

def setup_log():
    with open(LOG_FILE, "w", newline="") as f:
        csv.writer(f).writerow([
            "timestamp", "pressure_MPa", 
            "displacement_mm", "alert"
        ])

def log_reading(pressure, displacement, alert):
    with open(LOG_FILE, "a", newline="") as f:
        csv.writer(f).writerow([
            datetime.now().strftime("%Y-%m-%d %H:%M:%S"),
            pressure, displacement, alert
        ])

def print_dashboard(pressure, displacement, alert, step):
    colors = {
        "SAFE":    "\033[92m",   # green
        "WARNING": "\033[93m",   # yellow
        "DANGER":  "\033[91m",   # red
    }
    reset = "\033[0m"
    c = colors[alert]

    phase = (
        "SAFE (load rising)"        if step % 25 < 10  else
        "WARNING (nearing limit)"   if step % 25 < 15  else
        "DANGER (critical!)"        if step % 25 < 20  else
        "RECOVERY (load dropping)"
    )

    print(c + "─────────────────────────────────────────" + reset)
    print(c + f"  Step {step % 25}/25 — {phase}" + reset)
    print(f"  Pressure:    {pressure:5.2f} MPa")
    print(f"  Convergence: {displacement:5.2f} mm")
    print(c + f"  Alert:       {alert}" + reset)

if __name__ == "__main__":
    setup_log()
    print("Data generator running — Ctrl+C to stop\n")
    step = 0
    try:
        while True:
            pressure, displacement = simulate_reading(step)
            alert = get_alert(pressure, displacement)
            log_reading(pressure, displacement, alert)
            print_dashboard(pressure, displacement, alert, step)
            step += 1
            time.sleep(2)
    except KeyboardInterrupt:
        print("\nStopped. Log saved to", LOG_FILE)