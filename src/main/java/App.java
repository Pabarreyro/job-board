import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import models.Job;
import models.Company;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {

        staticFileLocation("/public");

        get("/jobs/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "jobs-form.hbs");
        }, new HandlebarsTemplateEngine());
//
        post("/jobs/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String title = request.queryParams("title");
            String qualifications = request.queryParams("qualifications");
            String company = request.queryParams("company");
            int salary = Integer.parseInt(request.queryParams("salary"));
            Job newJob = new Job(title, qualifications, company, salary);
            response.redirect("/jobs");
            return null;
        }, new HandlebarsTemplateEngine());
//
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/jobs", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("jobs", Job.getAll());
            return new ModelAndView(model, "jobs.hbs");
        }, new HandlebarsTemplateEngine());
//
//        get("/jobs/delete", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            Job.clearAll();
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//
        get("/jobs/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfJobToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Job foundJob = Job.findById(idOfJobToFind); //use it to find job
            model.put("job", foundJob); //add it to model for template to display
            return new ModelAndView(model, "job-detail.hbs"); //individual job page.
        }, new HandlebarsTemplateEngine());
//
        get("/jobs/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfJobToEdit = Integer.parseInt(req.params("id"));
            Job editJob = Job.findById(idOfJobToEdit);
            model.put("editJob", editJob);
            return new ModelAndView(model, "job-form.hbs");
        }, new HandlebarsTemplateEngine());
//
//        post("/jobs/:id/update", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfJobToEdit = Integer.parseInt(req.params("id"));
//            String newContent = req.queryParams("content");
//            Job editJob = Job.findById(idOfJobToEdit);
////            editJob.update(newContent);
//            model.put("job", editJob);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//
//
//        get("/jobs/:id/delete", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfJobToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
//            Job deleteJob = Job.findById(idOfJobToDelete); //use it to find job
//            deleteJob.deleteJob();
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
    }
}
