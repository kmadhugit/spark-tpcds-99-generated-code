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
/* 013 */   private java.util.ArrayList smj_matches;
/* 014 */   private UTF8String smj_value3;
/* 015 */   private UTF8String smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private double smj_value5;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 019 */   private UnsafeRow smj_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 022 */   private UnsafeRow project_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 025 */
/* 026 */   public GeneratedIterator(Object[] references) {
/* 027 */     this.references = references;
/* 028 */   }
/* 029 */
/* 030 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 031 */     partitionIndex = index;
/* 032 */     this.inputs = inputs;
/* 033 */     smj_leftInput = inputs[0];
/* 034 */     smj_rightInput = inputs[1];
/* 035 */
/* 036 */     smj_rightRow = null;
/* 037 */
/* 038 */     smj_matches = new java.util.ArrayList();
/* 039 */
/* 040 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 041 */     smj_result = new UnsafeRow(5);
/* 042 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 043 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 044 */     project_result = new UnsafeRow(4);
/* 045 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 64);
/* 046 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 047 */
/* 048 */   }
/* 049 */
/* 050 */   private boolean findNextInnerJoinRows(
/* 051 */     scala.collection.Iterator leftIter,
/* 052 */     scala.collection.Iterator rightIter) {
/* 053 */     smj_leftRow = null;
/* 054 */     int comp = 0;
/* 055 */     while (smj_leftRow == null) {
/* 056 */       if (!leftIter.hasNext()) return false;
/* 057 */       smj_leftRow = (InternalRow) leftIter.next();
/* 058 */
/* 059 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 060 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 061 */       if (smj_isNull) {
/* 062 */         smj_leftRow = null;
/* 063 */         continue;
/* 064 */       }
/* 065 */       if (!smj_matches.isEmpty()) {
/* 066 */         comp = 0;
/* 067 */         if (comp == 0) {
/* 068 */           comp = smj_value.compare(smj_value3);
/* 069 */         }
/* 070 */
/* 071 */         if (comp == 0) {
/* 072 */           return true;
/* 073 */         }
/* 074 */         smj_matches.clear();
/* 075 */       }
/* 076 */
/* 077 */       do {
/* 078 */         if (smj_rightRow == null) {
/* 079 */           if (!rightIter.hasNext()) {
/* 080 */             smj_value3 = smj_value.clone();
/* 081 */             return !smj_matches.isEmpty();
/* 082 */           }
/* 083 */           smj_rightRow = (InternalRow) rightIter.next();
/* 084 */
/* 085 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 086 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 087 */           if (smj_isNull1) {
/* 088 */             smj_rightRow = null;
/* 089 */             continue;
/* 090 */           }
/* 091 */           smj_value2 = smj_value1.clone();
/* 092 */         }
/* 093 */
/* 094 */         comp = 0;
/* 095 */         if (comp == 0) {
/* 096 */           comp = smj_value.compare(smj_value2);
/* 097 */         }
/* 098 */
/* 099 */         if (comp > 0) {
/* 100 */           smj_rightRow = null;
/* 101 */         } else if (comp < 0) {
/* 102 */           if (!smj_matches.isEmpty()) {
/* 103 */             smj_value3 = smj_value.clone();
/* 104 */             return true;
/* 105 */           }
/* 106 */           smj_leftRow = null;
/* 107 */         } else {
/* 108 */           smj_matches.add(smj_rightRow.copy());
/* 109 */           smj_rightRow = null;;
/* 110 */         }
/* 111 */       } while (smj_leftRow != null);
/* 112 */     }
/* 113 */     return false; // unreachable
/* 114 */   }
/* 115 */
/* 116 */   protected void processNext() throws java.io.IOException {
/* 117 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 118 */       int smj_size = smj_matches.size();
/* 119 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 120 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 121 */       smj_value5 = smj_leftRow.getDouble(1);
/* 122 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 123 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 124 */
/* 125 */         smj_numOutputRows.add(1);
/* 126 */
/* 127 */         boolean smj_isNull4 = smj_rightRow1.isNullAt(1);
/* 128 */         UTF8String smj_value7 = smj_isNull4 ? null : (smj_rightRow1.getUTF8String(1));
/* 129 */         boolean smj_isNull5 = smj_rightRow1.isNullAt(2);
/* 130 */         double smj_value8 = smj_isNull5 ? -1.0 : (smj_rightRow1.getDouble(2));
/* 131 */         project_holder.reset();
/* 132 */
/* 133 */         project_rowWriter.zeroOutNullBytes();
/* 134 */
/* 135 */         if (smj_isNull2) {
/* 136 */           project_rowWriter.setNullAt(0);
/* 137 */         } else {
/* 138 */           project_rowWriter.write(0, smj_value4);
/* 139 */         }
/* 140 */
/* 141 */         project_rowWriter.write(1, smj_value5);
/* 142 */
/* 143 */         if (smj_isNull4) {
/* 144 */           project_rowWriter.setNullAt(2);
/* 145 */         } else {
/* 146 */           project_rowWriter.write(2, smj_value7);
/* 147 */         }
/* 148 */
/* 149 */         if (smj_isNull5) {
/* 150 */           project_rowWriter.setNullAt(3);
/* 151 */         } else {
/* 152 */           project_rowWriter.write(3, smj_value8);
/* 153 */         }
/* 154 */         project_result.setTotalSize(project_holder.totalSize());
/* 155 */         append(project_result.copy());
/* 156 */
/* 157 */       }
/* 158 */       if (shouldStop()) return;
/* 159 */     }
/* 160 */   }
/* 161 */ }
