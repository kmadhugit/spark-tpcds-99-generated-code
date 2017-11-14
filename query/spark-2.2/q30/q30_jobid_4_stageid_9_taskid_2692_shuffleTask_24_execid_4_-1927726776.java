/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private UTF8String smj_value2;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private UTF8String smj_value3;
/* 015 */   private long smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private UTF8String smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private double smj_value6;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 021 */   private UnsafeRow smj_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     smj_leftInput = inputs[0];
/* 036 */     smj_rightInput = inputs[1];
/* 037 */
/* 038 */     smj_rightRow = null;
/* 039 */
/* 040 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 041 */
/* 042 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 043 */     smj_result = new UnsafeRow(5);
/* 044 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 64);
/* 045 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 046 */     project_result = new UnsafeRow(2);
/* 047 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 048 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 049 */
/* 050 */   }
/* 051 */
/* 052 */   private boolean findNextInnerJoinRows(
/* 053 */     scala.collection.Iterator leftIter,
/* 054 */     scala.collection.Iterator rightIter) {
/* 055 */     smj_leftRow = null;
/* 056 */     int comp = 0;
/* 057 */     while (smj_leftRow == null) {
/* 058 */       if (!leftIter.hasNext()) return false;
/* 059 */       smj_leftRow = (InternalRow) leftIter.next();
/* 060 */
/* 061 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 062 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(1));
/* 063 */       if (smj_isNull) {
/* 064 */         smj_leftRow = null;
/* 065 */         continue;
/* 066 */       }
/* 067 */       if (!smj_matches.isEmpty()) {
/* 068 */         comp = 0;
/* 069 */         if (comp == 0) {
/* 070 */           comp = smj_value.compare(smj_value3);
/* 071 */         }
/* 072 */
/* 073 */         if (comp == 0) {
/* 074 */           return true;
/* 075 */         }
/* 076 */         smj_matches.clear();
/* 077 */       }
/* 078 */
/* 079 */       do {
/* 080 */         if (smj_rightRow == null) {
/* 081 */           if (!rightIter.hasNext()) {
/* 082 */             smj_value3 = smj_value.clone();
/* 083 */             return !smj_matches.isEmpty();
/* 084 */           }
/* 085 */           smj_rightRow = (InternalRow) rightIter.next();
/* 086 */
/* 087 */           boolean smj_isNull1 = smj_rightRow.isNullAt(1);
/* 088 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(1));
/* 089 */           if (smj_isNull1) {
/* 090 */             smj_rightRow = null;
/* 091 */             continue;
/* 092 */           }
/* 093 */           smj_value2 = smj_value1.clone();
/* 094 */         }
/* 095 */
/* 096 */         comp = 0;
/* 097 */         if (comp == 0) {
/* 098 */           comp = smj_value.compare(smj_value2);
/* 099 */         }
/* 100 */
/* 101 */         if (comp > 0) {
/* 102 */           smj_rightRow = null;
/* 103 */         } else if (comp < 0) {
/* 104 */           if (!smj_matches.isEmpty()) {
/* 105 */             smj_value3 = smj_value.clone();
/* 106 */             return true;
/* 107 */           }
/* 108 */           smj_leftRow = null;
/* 109 */         } else {
/* 110 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 111 */           smj_rightRow = null;;
/* 112 */         }
/* 113 */       } while (smj_leftRow != null);
/* 114 */     }
/* 115 */     return false; // unreachable
/* 116 */   }
/* 117 */
/* 118 */   protected void processNext() throws java.io.IOException {
/* 119 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 120 */       boolean smj_loaded = false;
/* 121 */       smj_value6 = smj_leftRow.getDouble(2);
/* 122 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 123 */       while (smj_iterator.hasNext()) {
/* 124 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 125 */         double smj_value7 = smj_rightRow1.getDouble(0);
/* 126 */
/* 127 */         boolean smj_isNull6 = false;
/* 128 */
/* 129 */         boolean smj_value9 = false;
/* 130 */         smj_value9 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value6, smj_value7) > 0;
/* 131 */         if (false || !smj_value9) continue;
/* 132 */         if (!smj_loaded) {
/* 133 */           smj_loaded = true;
/* 134 */           smj_isNull2 = smj_leftRow.isNullAt(0);
/* 135 */           smj_value4 = smj_isNull2 ? -1L : (smj_leftRow.getLong(0));
/* 136 */           smj_isNull3 = smj_leftRow.isNullAt(1);
/* 137 */           smj_value5 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(1));
/* 138 */         }
/* 139 */         boolean smj_isNull5 = smj_rightRow1.isNullAt(1);
/* 140 */         UTF8String smj_value8 = smj_isNull5 ? null : (smj_rightRow1.getUTF8String(1));
/* 141 */         smj_numOutputRows.add(1);
/* 142 */
/* 143 */         project_rowWriter.zeroOutNullBytes();
/* 144 */
/* 145 */         if (smj_isNull2) {
/* 146 */           project_rowWriter.setNullAt(0);
/* 147 */         } else {
/* 148 */           project_rowWriter.write(0, smj_value4);
/* 149 */         }
/* 150 */
/* 151 */         project_rowWriter.write(1, smj_value6);
/* 152 */         append(project_result.copy());
/* 153 */
/* 154 */       }
/* 155 */       if (shouldStop()) return;
/* 156 */     }
/* 157 */   }
/* 158 */ }
