/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.service;

import Assignment1.Food;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author haofangliu
 */
@Stateless
@Path("assignment1.food")
public class FoodFacadeREST extends AbstractFacade<Food> {

    @PersistenceContext(unitName = "Assignment1PU")
    private EntityManager em;

    public FoodFacadeREST() {
        super(Food.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Food entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Food entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Food find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Food> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Food> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("findByFoodname/{foodname}")
    @Produces({"application/json"})
    public List<Food> findByFoodname(@PathParam("foodname") String foodname) {
    Query query = em.createNamedQuery("Food.findByFoodname");
    query.setParameter("foodname", foodname);
    return query.getResultList();
    }
    
    @GET
    @Path("findByCategory/{category}")
    @Produces({"application/json"})
    public List<Food> findByCategory(@PathParam("category") String category) {
    Query query = em.createNamedQuery("Food.findByCategory");
    query.setParameter("category", category);
    return query.getResultList();
    }
    
    @GET
    @Path("findByCalorieamount/{calorieamount}")
    @Produces({"application/json"})
    public List<Food> findByCalorieamount(@PathParam("calorieamount") int calorieamount) {
    Query query = em.createNamedQuery("Food.findByCalorieamount");
    query.setParameter("calorieamount", calorieamount);
    return query.getResultList();
    }
    
    @GET
    @Path("findByServingunit/{servingunit}")
    @Produces({"application/json"})
    public List<Food> findByServingunit(@PathParam("servingunit") String servingunit) {
    Query query = em.createNamedQuery("Food.findByServingunit");
    query.setParameter("servingunit", servingunit);
    return query.getResultList();
    }
    
    @GET
    @Path("findByServingamount/{servingamount}")
    @Produces({"application/json"})
    public List<Food> findByServingamount(@PathParam("servingamount") BigDecimal servingamount) {
    Query query = em.createNamedQuery("Food.findByServingamount");
    query.setParameter("servingamount", servingamount);
    return query.getResultList();
    }
    
    @GET
    @Path("findByFat/{fat}")
    @Produces({"application/json"})
    public List<Food> findByFat(@PathParam("fat") int fat) {
    Query query = em.createNamedQuery("Food.findByFat");
    query.setParameter("fat", fat);
    return query.getResultList();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
