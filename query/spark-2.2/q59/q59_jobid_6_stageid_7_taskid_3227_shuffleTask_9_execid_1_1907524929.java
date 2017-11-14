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
/* 038 */     boolean isNull2 = i.isNullAt(1);
/* 039 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(1));
/* 040 */     if (!isNull2) {
/* 041 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value2.getBaseObject(), value2.getBaseOffset(), value2.numBytes(), value1);
/* 042 */     }
/* 043 */
/* 044 */     boolean isNull3 = true;
/* 045 */     int value3 = -1;
/* 046 */
/* 047 */     boolean isNull4 = i.isNullAt(0);
/* 048 */     int value4 = isNull4 ? -1 : (i.getInt(0));
/* 049 */     if (!isNull4) {
/* 050 */
/* 051 */
/* 052 */       isNull3 = false; // resultCode could change nullability.
/* 053 */       value3 = value4 - 52;
/* 054 */
/* 055 */     }
/* 056 */     if (!isNull3) {
/* 057 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value3, value1);
/* 058 */     }
/* 059 */
/* 060 */     int value = -1;
/* 061 */
/* 062 */     int remainder = value1 % 64;
/* 063 */     if (remainder < 0) {
/* 064 */       value = (remainder + 64) % 64;
/* 065 */     } else {
/* 066 */       value = remainder;
/* 067 */     }
/* 068 */     rowWriter.write(0, value);
/* 069 */     return result;
/* 070 */   }
/* 071 */ }
