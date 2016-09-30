using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Threading.Tasks;
using System.Net;
using System.Web;
using System.Web.Mvc;
using DataAccess;

namespace B2CTouresBalon.Controllers
{
    public class CustomerController : Controller
    {
        private ClientContext db = new ClientContext();

        // GET: Customer
        public async Task<ActionResult> Index()
        {
            return RedirectToAction("Index", "Home");
        }

        // POST: Customer/Details/5
        public async Task<ActionResult> Details(decimal id)
        {
            var cUSTOMER = await db.CUSTOMER.FindAsync(id);
            if (cUSTOMER == null)
            {
                return HttpNotFound();
            }
            return View(cUSTOMER);
        }

        // GET: Customer/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Customer/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create([Bind(Include = "CUSTID,FNAME,LNAME,PHONENUMBER,EMAIL,PASSWORD,CREDITCARDTYPE,CREDITCARDNUMBER,STATUS")] CUSTOMER cUSTOMER)
        {
            if (!ModelState.IsValid) return View(cUSTOMER);
            db.CUSTOMER.Add(cUSTOMER);
            await db.SaveChangesAsync();
            return RedirectToAction("Index","Home");
        }

        // GET: Customer/Edit/5
        public async Task<ActionResult> Edit(decimal id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            var cUSTOMER = await db.CUSTOMER.FindAsync(id);
            if (cUSTOMER == null)
            {
                return HttpNotFound();
            }
            return View(cUSTOMER);
        }

        // POST: Customer/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit([Bind(Include = "FNAME,LNAME,PHONENUMBER,EMAIL,PASSWORD,CREDITCARDTYPE,CREDITCARDNUMBER")] CUSTOMER cUSTOMER)
        {
            if (!ModelState.IsValid) return View(cUSTOMER);
            db.Entry(cUSTOMER).State = EntityState.Modified;
            await db.SaveChangesAsync();
            return RedirectToAction("Index");
        }

       protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
