package service.serviceImpl;

import dao.CompanyDao;
import dao.daoImpl.CompanyDaoImpl;
import entity.Company;
import exception.ShowException;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.CompanyService;
import sessionFactory.SessionFactoryImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    CompanyDao companyDao = new CompanyDaoImpl();

    public CompanyServiceImpl() {
    }

    @Override
    public boolean addCompany(Company company) {
        boolean isAdded = false;
        try {
            companyDao.addCompany(company);
            isAdded = true;
        } catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateCompany(Company company) {
        boolean isUpdated = false;
        System.out.println("Это ДЗ (готово)");
        try {
            if (companyDao.updateCompany(company))
                isUpdated = true;
        } catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCompany(int id) {
        System.out.println("Это ДЗ (готово)");
        boolean isDeleted = false;
        try {
            if (companyDao.deleteCompany(id))
                isDeleted = true;
        } catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isDeleted;
    }

    @Override
    public List<Company> showCompanies() {
        System.out.println("Это ДЗ showCompanies (готово)");
        List<Company> companies = (List<Company>) SessionFactoryImpl.getSessionFactory().openSession().createQuery("FROM Company").list();
        return companies;

        // return null;
    }

    @Override
    public Company findCompanyById(int id) {
        System.out.println("Это ДЗ (готово)");
        Company company = null;
        try {
            company = companyDao.findCompanyById(id);
        } catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return company;
        //return null;
    }

    @Override
    public Company findCompanyByName(String name) {
        System.out.println("Это ДЗ CompanyServiceImpl.findCompanyByName");
        Company company = null;
        try {
           company = companyDao.findCompanyByName(name);
        } catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return company;
        //return null;
    }
}
