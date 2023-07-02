package hr.tvz.buykoserver.hibernate

class Import {

    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    annotation class SQLQuerry(val value: String)
    
}