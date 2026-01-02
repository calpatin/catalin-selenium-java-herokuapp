# Selenium Test Automation Framework (Java 17)

## Overview

This repository contains a **public, interview‑ready Selenium test automation framework** built with **Java 17, Selenium 4, TestNG and Cucumber (BDD)**.

The goal of the project is **not only to automate tests**, but to **demonstrate framework design, architectural decisions, Selenium best practices and real‑world limitations** that typically appear in enterprise projects.

The framework is intentionally built step‑by‑step on top of the demo application:

> [https://the-internet.herokuapp.com](https://the-internet.herokuapp.com)

This site is widely used in the QA community and allows us to cover almost the entire Selenium API in a **stable and predictable way**.

---

## Tech Stack

* **Java 17**
* **Selenium 4**
* **TestNG** (test execution & orchestration)
* **Cucumber (BDD)**
* **WebDriverManager** (automatic driver management)
* **Maven**

---

## Project Structure

```
src
 ├── main
 │   └── java
 │       └── com.catalin.selenium.framework
 │           ├── driver        # WebDriver lifecycle & ThreadLocal
 │           ├── pages         # Page Objects
 │           ├── utils         # Utilities (waits, helpers)
 │           └── enums
 └── test
     ├── java
     │   └── com.catalin.selenium
     │       ├── runners       # Cucumber + TestNG runner
     │       ├── steps         # Step definitions
     │       └── hooks         # Cucumber hooks (@Before / @After)
     └── resources
         └── features          # Gherkin feature files
```

### Key principle

> **Framework code is separated from test logic.**

* `framework` → infrastructure & reusable logic
* `steps` → orchestration only (no Selenium API calls)

---

## Test Runner

The framework uses **Cucumber integrated with TestNG**.

```java
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {
        "com.catalin.selenium.steps",
        "com.catalin.selenium.hooks"
    },
    plugin = {
        "pretty",
        "html:target/cucumber-report.html"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {}
```

### Design decisions

* No hard‑coded tags in the runner
* Tag filtering is controlled via **VM options / Maven / CI: -Dcucumber.filter.tags="@Run and not (@Defect or @Flaky)"**
* Runner contains **no Selenium logic**

---

## WebDriver Management

* WebDriver lifecycle is handled centrally
* Uses **WebDriverManager** (no drivers committed to the repo)
* **ThreadLocal WebDriver** is used to support future parallel execution

### Why ThreadLocal?

* Each test thread gets its own WebDriver instance
* Required for safe parallel execution

---

## BasePage – Framework Core

`BasePage` contains **all shared Selenium infrastructure**:

* Explicit waits
* Fluent waits
* Click & text helpers
* Actions
* Alerts
* Frames
* Windows / tabs

### Visibility vs Clickability

* Default `click()` waits for **visibility**, not clickability
* `elementToBeClickable` is used **only when explicitly needed**

This avoids unnecessary timeouts on simple navigation links.

---

## Wait Strategy

### What we use

* **Explicit Waits** (`WebDriverWait`)
* **FluentWait** (custom polling, ignored exceptions)

### What we intentionally do NOT use

* `Thread.sleep()`
*  Implicit waits

### Presence vs Visibility

* **presenceOfElementLocated** → element exists in DOM
* **visibilityOf** → element is visible to the user

This distinction is demonstrated using *Dynamic Loading – Example 1 & 2*.

---

## Page Object Model

* All pages use **`@FindBy` + PageFactory**
* Selenium logic is hidden inside Page Objects
* Step definitions never call Selenium APIs directly

### Hybrid `@FindBy` + `By`

For dynamic elements (e.g. elements not initially present in DOM):

* `By` is used for **presence waits**
* `@FindBy` is used for **interaction & visibility**

This avoids flaky tests and stale element issues.

---

## BDD & Cucumber Design

### Scenario Outline vs DataTable

* **Scenario Outline** → multiple executions, one per row
* **DataTable** → same scenario, multiple values

Both approaches are used intentionally depending on the use case.

---

## Alerts Handling

Covered scenarios:

* Simple alert
* Confirmation alert (accept / dismiss)
* Prompt alert (sendKeys)

### Key principles

* Alerts are **not WebElements**
* Always use explicit wait: `alertIsPresent()`
* Alert handling is done in Page Objects

---

## Frames & iFrames

Covered scenarios:

* Nested frames
* iFrame (TinyMCE editor)

### Important lessons

* Selenium must switch context **explicitly**
* `frame-top` exists as a frameset even if it is not visible
* Always return to `defaultContent()`

### TinyMCE specifics

* TinyMCE uses `contenteditable`, not input fields
* `clear()` does NOT work
* Input requires focus + keyboard simulation
* Demo editor is **read‑only** → scenario marked as `@Defect`

This reflects real‑world test constraints.

---

## Actions API

Covered Actions:

* Hover (`moveToElement`)
* Right click (`contextClick`)
* Drag & Drop

### Hover – Common Pitfall

* All captions exist in DOM
* Only one is visible at a time
* Assertions must validate the **visible element**, not list index

---

## Drag & Drop – Known Selenium Limitation

* Selenium Actions **do not support HTML5 drag & drop reliably**
* Actions‑based scenario is intentionally marked as `@Defect`

### Why?

HTML5 drag & drop requires browser events that Selenium Actions do not trigger.

This limitation is **documented**, not hidden.

---

## Windows / Tabs

Key concepts covered:

* `getWindowHandle()`
* `getWindowHandles()`
* Safe switching without relying on index

### Design rule

* Steps do not access BasePage directly
* Page Objects expose public wrapper methods
* BasePage methods remain `protected`

This preserves encapsulation and clean architecture.

---

## Tagging Strategy

Examples:

* `@UI`
* `@actions`
* `@frames`
* `@select`
* `@Defect`

### Why `@Defect` exists

* Some demo site behaviors are intentionally broken or limited
* Tests reflect reality instead of forcing impossible behavior

---

## Key Principles Demonstrated

* Clean separation of concerns
* Explicit waits only
* No Selenium logic in steps
* Defensive handling of UI limitations
* Stable and explainable tests
* Realistic enterprise‑style decisions

---

## Final Notes

This framework is designed to:

* Be easy to explain in interviews
* Serve as a reference for Selenium best practices
* Demonstrate real‑world limitations and how to handle them

> **The goal is not perfect automation — the goal is correct automation.**
