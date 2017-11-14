/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private UnsafeRow result;
/* 009 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 011 */
/* 012 */   public SpecificUnsafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     result = new UnsafeRow(1);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 1);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */
/* 026 */   // Scala.Function1 need this
/* 027 */   public java.lang.Object apply(java.lang.Object row) {
/* 028 */     return apply((InternalRow) row);
/* 029 */   }
/* 030 */
/* 031 */   public UnsafeRow apply(InternalRow i) {
/* 032 */     rowWriter.zeroOutNullBytes();
/* 033 */
/* 034 */
/* 035 */     boolean isNull = true;
/* 036 */     long value = -1L;
/* 037 */
/* 038 */     boolean isNull1 = true;
/* 039 */     long value1 = -1L;
/* 040 */
/* 041 */     boolean isNull3 = i.isNullAt(1);
/* 042 */     int value3 = isNull3 ? -1 : (i.getInt(1));
/* 043 */     boolean isNull2 = isNull3;
/* 044 */     long value2 = -1L;
/* 045 */     if (!isNull3) {
/* 046 */       value2 = (long) value3;
/* 047 */     }
/* 048 */     if (!isNull2) {
/* 049 */
/* 050 */
/* 051 */       isNull1 = false; // resultCode could change nullability.
/* 052 */       value1 = value2 << 32;
/* 053 */
/* 054 */     }
/* 055 */     if (!isNull1) {
/* 056 */
/* 057 */       boolean isNull5 = true;
/* 058 */       long value5 = -1L;
/* 059 */
/* 060 */       boolean isNull7 = i.isNullAt(0);
/* 061 */       int value7 = isNull7 ? -1 : (i.getInt(0));
/* 062 */       boolean isNull6 = isNull7;
/* 063 */       long value6 = -1L;
/* 064 */       if (!isNull7) {
/* 065 */         value6 = (long) value7;
/* 066 */       }
/* 067 */       if (!isNull6) {
/* 068 */
/* 069 */
/* 070 */         isNull5 = false; // resultCode could change nullability.
/* 071 */         value5 = value6 & 4294967295L;
/* 072 */
/* 073 */       }
/* 074 */       if (!isNull5) {
/* 075 */
/* 076 */         isNull = false; // resultCode could change nullability.
/* 077 */         value = value1 | value5;
/* 078 */
/* 079 */       }
/* 080 */
/* 081 */     }
/* 082 */     if (isNull) {
/* 083 */       rowWriter.setNullAt(0);
/* 084 */     } else {
/* 085 */       rowWriter.write(0, value);
/* 086 */     }
/* 087 */     return result;
/* 088 */   }
/* 089 */ }
