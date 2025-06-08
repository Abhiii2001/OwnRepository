package com.seeder;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.Entity.Role;
import com.enums.RoleEnum;
import com.repository.RoleRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
@Order(1)
public class RoleSeeder implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private RoleRepo rRepo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		loadEvent();
		log.debug("IN ON APPLLICATION EVENT");
	}

	private void loadEvent() {

		RoleEnum[] renum = new RoleEnum[] { RoleEnum.USER, RoleEnum.ADMIN, RoleEnum.SUPER_ADMIN };
		Map<RoleEnum, String> roleDescription = new HashMap<>();
		roleDescription.put(RoleEnum.USER, "Default User Role");
		roleDescription.put(RoleEnum.ADMIN, "Administration Role");
		roleDescription.put(RoleEnum.SUPER_ADMIN, "Super Administration");

		for (RoleEnum roleEnum : renum) {

			boolean isRoleEmpty = !rRepo.findByRolename(roleEnum).isPresent();

			if (isRoleEmpty) {
				Role role = new Role();
				role.setRolename(roleEnum);
				role.setDescription(roleDescription.get(roleEnum));
				rRepo.save(role);

			}
		}

	}
}
