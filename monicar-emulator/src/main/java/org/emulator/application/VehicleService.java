package org.emulator.application;

import lombok.RequiredArgsConstructor;
import org.emulator.application.port.EmulatorRepository;
import org.emulator.application.port.LocationEventPublisher;
import org.emulator.application.port.VehicleCommandSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VehicleService {
    private final EmulatorRepository emulatorRepository;
    private final LocationEventPublisher locationEventPublisher;
    private final VehicleCommandSender vehicleCommandSender;
}
