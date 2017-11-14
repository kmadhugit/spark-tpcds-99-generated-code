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
/* 027 */   private void apply_1(InternalRow i) {
/* 028 */
/* 029 */     int value6 = i.getInt(8);
/* 030 */     value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(value6, value1);
/* 031 */   }
/* 032 */
/* 033 */
/* 034 */   private void apply_0(InternalRow i) {
/* 035 */
/* 036 */     boolean isNull2 = i.isNullAt(0);
/* 037 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 038 */     if (!isNull2) {
/* 039 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value2.getBaseObject(), value2.getBaseOffset(), value2.numBytes(), value1);
/* 040 */     }
/* 041 */
/* 042 */     boolean isNull3 = i.isNullAt(1);
/* 043 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(1));
/* 044 */     if (!isNull3) {
/* 045 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value3.getBaseObject(), value3.getBaseOffset(), value3.numBytes(), value1);
/* 046 */     }
/* 047 */
/* 048 */     boolean isNull4 = i.isNullAt(2);
/* 049 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(2));
/* 050 */     if (!isNull4) {
/* 051 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value4.getBaseObject(), value4.getBaseOffset(), value4.numBytes(), value1);
/* 052 */     }
/* 053 */
/* 054 */     boolean isNull5 = i.isNullAt(3);
/* 055 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(3));
/* 056 */     if (!isNull5) {
/* 057 */       value1 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(value5.getBaseObject(), value5.getBaseOffset(), value5.numBytes(), value1);
/* 058 */     }
/* 059 */
/* 060 */   }
/* 061 */
/* 062 */
/* 063 */   // Scala.Function1 need this
/* 064 */   public java.lang.Object apply(java.lang.Object row) {
/* 065 */     return apply((InternalRow) row);
/* 066 */   }
/* 067 */
/* 068 */   public UnsafeRow apply(InternalRow i) {
/* 069 */     boolean isNull = false;
/* 070 */
/* 071 */     value1 = 42;
/* 072 */     apply_0(i);
/* 073 */     apply_1(i);
/* 074 */
/* 075 */     int value = -1;
/* 076 */
/* 077 */     int remainder = value1 % 64;
/* 078 */     if (remainder < 0) {
/* 079 */       value = (remainder + 64) % 64;
/* 080 */     } else {
/* 081 */       value = remainder;
/* 082 */     }
/* 083 */     rowWriter.write(0, value);
/* 084 */     return result;
/* 085 */   }
/* 086 */ }
