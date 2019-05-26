package br.com.icardapio.multitenancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.icardapio.entity.Restaurant;
import br.com.icardapio.repositories.RestaurantRepository;

public class ICardapioTenantResolver implements CurrentTenantResolver<Long> {
	
	private static String MASTER_TENANT_SUBDOMAIN = "default";
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	protected Long getCurrentTenantFromSubdomain() {
		ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		String[] url = attr.getRequest().getRequestURL().toString().split("/");
		String subdomain = url[url.length-1];
		
		if (subdomain.equals("addProduct")){ 
			subdomain = url[url.length-2];
		}
		
		Restaurant restaurant = restaurantRepository.getBySubdomain(subdomain);
		return restaurant != null ? restaurant.getTenantId() : 0;
	}

	
	@Override
	public Long getMasterTenantId() {
		return restaurantRepository.getBySubdomain(MASTER_TENANT_SUBDOMAIN).getTenantId();
	}

	@Override
	public boolean isMasterTenant() {
		Long masterTenant = getMasterTenantId();
		Long tenantFromSubdomain = getCurrentTenantFromSubdomain();
		
		return masterTenant.equals(tenantFromSubdomain);
	}
	
	@Override
	public Long getCurrentTenantId() {
		return getCurrentTenantFromSubdomain();
	}	

}
