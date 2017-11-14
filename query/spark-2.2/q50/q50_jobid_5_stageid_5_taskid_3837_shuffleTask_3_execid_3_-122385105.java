/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private int value1;
/* 009 */   private UnsafeRow result;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 012 */
/* 013 */   public SpecificUnsafeProjection(Object[] references) {
/* 014 */     this.references = references;
/* 015 */
/* 016 */     result = new UnsafeRow(1);
/* 017 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 018 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 1);
/* 019 */
/* 020 */   }
/* 021 */
/* 022 */   public void initialize(int partitionIndex) {
/* 023 */
/* 024 */   }
/* 025 */
/* 026 */
/* 027 */
/* 028 */   // Scala.Function1 need this
/* 029 */   public java.lang.Object apply(java.lang.Object row) {
/* 030 */     return apply((InternalRow) row);
/* 031 */   }
/* 032 */
/* 033 */   public UnsafeRow apply(InternalRow i) {
/* 034 */     boolean isNull = false;
/* 035 */
/* 036 */     value1 = 42;
/* 037 */
/* 038 */     boolean isNull3 = i.isNullAt(3);
/* 039 */     int value3 = isNull3 ? -1 : (i.getInt(3));
/* 040 */     boolean isNull2 = isNull3;
/* 041 */     long value2 = -1L;
/* 042 */     if (!isNull3) {
/* 043 */       value2 = (long) value3;
/* 044 */     }
/* 045 */     if (!isNull2) {
/* 046 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(value2, value1);
/* 047 */     }
/* 048 */
/* 049 */     boolean isNull5 = i.isNullAt(0);
/* 050 */     int value5 = isNull5 ? -1 : (i.getInt(0));
/* 051 */     boolean isNull4 = isNull5;
/* 052 */     long value4 = -1L;
/* 053 */     if (!isNull5) {
/* 054 */       value4 = (long) value5;
/* 055 */     }
/* 056 */     if (!isNull4) {
/* 057 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(value4, value1);
/* 058 */     }
/* 059 */
/* 060 */     boolean isNull7 = i.isNullAt(1);
/* 061 */     int value7 = isNull7 ? -1 : (i.getInt(1));
/* 062 */     boolean isNull6 = isNull7;
/* 063 */     long value6 = -1L;
/* 064 */     if (!isNull7) {
/* 065 */       value6 = (long) value7;
/* 066 */     }
/* 067 */     if (!isNull6) {
/* 068 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(value6, value1);
/* 069 */     }
/* 070 */
/* 071 */     int value = -1;
/* 072 */
/* 073 */     int remainder = value1 % 64;
/* 074 */     if (remainder < 0) {
/* 075 */       value = (remainder + 64) % 64;
/* 076 */     } else {
/* 077 */       value = remainder;
/* 078 */     }
/* 079 */     rowWriter.write(0, value);
/* 080 */     return result;
/* 081 */   }
/* 082 */ }
