import { useState, useEffect } from 'react';
import { Text, View, StyleSheet } from 'react-native';
import { getBatteryLevel } from 'react-native-battery-status';

export default function App() {
  const [batteryLevel, setBatteryLevel] = useState<number | undefined | null>(
    null
  );
  useEffect(() => {
    const fetchBatteryLevel = async () => {
      try {
        const level = await getBatteryLevel();
        setBatteryLevel(level);
      } catch (error) {
        console.error('Error fetching battery level:', error);
      }
    };
    fetchBatteryLevel();
  }, []);
  return (
    <View style={styles.container}>
      <Text>Result: {batteryLevel}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
