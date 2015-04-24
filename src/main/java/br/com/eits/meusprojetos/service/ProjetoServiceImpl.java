package br.com.eits.meusprojetos.service;

import java.util.List;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.eits.meusprojetos.model.Projeto;
import br.com.eits.meusprojetos.repository.ProjetoRepository;

@Service
@Transactional
@RemoteProxy(name="projetoService")
public class ProjetoServiceImpl implements ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;
	
	/* (non-Javadoc)
	 * @see br.com.eits.meusprojetos.service.ProjetoService#add(br.com.eits.meusprojetos.model.Projeto)
	 */
	@Override
	public Projeto add(Projeto projeto) {
		return projetoRepository.save(projeto);
	}
	
	/* (non-Javadoc)
	 * @see br.com.eits.meusprojetos.service.ProjetoService#edit(br.com.eits.meusprojetos.model.Projeto)
	 */
	@Override
	public Projeto edit(Projeto projeto) {
		return projetoRepository.save(projeto);
	}
	
	/* (non-Javadoc)
	 * @see br.com.eits.meusprojetos.service.ProjetoService#remove(java.lang.Long)
	 */
	@Override
	public void remove(Long id) {
		projetoRepository.delete(id);
	}
	
	/* (non-Javadoc)
	 * @see br.com.eits.meusprojetos.service.ProjetoService#findAll()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<Projeto> findAll() {
		return projetoRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see br.com.eits.meusprojetos.service.ProjetoService#findById(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly=true)
	public Projeto findById(Long id) {
		return projetoRepository.findOne(id);
	}	
}
