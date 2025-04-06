import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  getBatteryLevel(): Promise<number>;
  isCharging(): Promise<boolean>;
  getPowerSource(): Promise<string>;
  isLowPowerMode(): Promise<boolean>;
}

export default TurboModuleRegistry.get<Spec>('BatteryStatus');
