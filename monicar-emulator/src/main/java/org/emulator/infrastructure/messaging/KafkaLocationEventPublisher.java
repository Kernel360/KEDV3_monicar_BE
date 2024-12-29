package org.emulator.infrastructure.messaging;

import org.emulator.application.port.LocationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class KafkaLocationEventPublisher implements LocationEventPublisher {
}
