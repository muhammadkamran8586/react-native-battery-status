import BatteryStatus from './NativeBatteryStatus';

export function getBatteryLevel(): Promise<number> | undefined {
  return BatteryStatus?.getBatteryLevel();
}
export function isCharging(): Promise<boolean> | undefined {
  return BatteryStatus?.isCharging();
}
export function getPowerSource(): Promise<string> | undefined {
  return BatteryStatus?.getPowerSource();
}
export function isLowPowerMode(): Promise<boolean> | undefined {
  return BatteryStatus?.isLowPowerMode();
}
