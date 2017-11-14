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
/* 012 */   private int smj_value2;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private int smj_value3;
/* 015 */   private int smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private int smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private UTF8String smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private double smj_value7;
/* 022 */   private boolean smj_isNull5;
/* 023 */   private double smj_value8;
/* 024 */   private boolean smj_isNull6;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 026 */   private UnsafeRow smj_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 029 */   private UnsafeRow project_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 032 */
/* 033 */   public GeneratedIterator(Object[] references) {
/* 034 */     this.references = references;
/* 035 */   }
/* 036 */
/* 037 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 038 */     partitionIndex = index;
/* 039 */     this.inputs = inputs;
/* 040 */     smj_leftInput = inputs[0];
/* 041 */     smj_rightInput = inputs[1];
/* 042 */
/* 043 */     smj_rightRow = null;
/* 044 */
/* 045 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 046 */
/* 047 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 048 */     smj_result = new UnsafeRow(8);
/* 049 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 050 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 8);
/* 051 */     project_result = new UnsafeRow(7);
/* 052 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 128);
/* 053 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 7);
/* 054 */
/* 055 */   }
/* 056 */
/* 057 */   private boolean findNextInnerJoinRows(
/* 058 */     scala.collection.Iterator leftIter,
/* 059 */     scala.collection.Iterator rightIter) {
/* 060 */     smj_leftRow = null;
/* 061 */     int comp = 0;
/* 062 */     while (smj_leftRow == null) {
/* 063 */       if (!leftIter.hasNext()) return false;
/* 064 */       smj_leftRow = (InternalRow) leftIter.next();
/* 065 */
/* 066 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 067 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 068 */       if (smj_isNull) {
/* 069 */         smj_leftRow = null;
/* 070 */         continue;
/* 071 */       }
/* 072 */       if (!smj_matches.isEmpty()) {
/* 073 */         comp = 0;
/* 074 */         if (comp == 0) {
/* 075 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 076 */         }
/* 077 */
/* 078 */         if (comp == 0) {
/* 079 */           return true;
/* 080 */         }
/* 081 */         smj_matches.clear();
/* 082 */       }
/* 083 */
/* 084 */       do {
/* 085 */         if (smj_rightRow == null) {
/* 086 */           if (!rightIter.hasNext()) {
/* 087 */             smj_value3 = smj_value;
/* 088 */             return !smj_matches.isEmpty();
/* 089 */           }
/* 090 */           smj_rightRow = (InternalRow) rightIter.next();
/* 091 */
/* 092 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 093 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 094 */           if (smj_isNull1) {
/* 095 */             smj_rightRow = null;
/* 096 */             continue;
/* 097 */           }
/* 098 */           smj_value2 = smj_value1;
/* 099 */         }
/* 100 */
/* 101 */         comp = 0;
/* 102 */         if (comp == 0) {
/* 103 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 104 */         }
/* 105 */
/* 106 */         if (comp > 0) {
/* 107 */           smj_rightRow = null;
/* 108 */         } else if (comp < 0) {
/* 109 */           if (!smj_matches.isEmpty()) {
/* 110 */             smj_value3 = smj_value;
/* 111 */             return true;
/* 112 */           }
/* 113 */           smj_leftRow = null;
/* 114 */         } else {
/* 115 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 116 */           smj_rightRow = null;;
/* 117 */         }
/* 118 */       } while (smj_leftRow != null);
/* 119 */     }
/* 120 */     return false; // unreachable
/* 121 */   }
/* 122 */
/* 123 */   protected void processNext() throws java.io.IOException {
/* 124 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 125 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 126 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 127 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 128 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 129 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 130 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 131 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 132 */       smj_value7 = smj_isNull5 ? -1.0 : (smj_leftRow.getDouble(3));
/* 133 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 134 */       smj_value8 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(4));
/* 135 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 136 */       while (smj_iterator.hasNext()) {
/* 137 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 138 */
/* 139 */         smj_numOutputRows.add(1);
/* 140 */
/* 141 */         boolean smj_isNull9 = smj_rightRow1.isNullAt(2);
/* 142 */         UTF8String smj_value11 = smj_isNull9 ? null : (smj_rightRow1.getUTF8String(2));
/* 143 */         boolean smj_isNull8 = smj_rightRow1.isNullAt(1);
/* 144 */         UTF8String smj_value10 = smj_isNull8 ? null : (smj_rightRow1.getUTF8String(1));
/* 145 */         boolean project_isNull2 = true;
/* 146 */         UTF8String project_value2 = null;
/* 147 */
/* 148 */         if (!smj_isNull4) {
/* 149 */           project_isNull2 = false; // resultCode could change nullability.
/* 150 */           project_value2 = smj_value6.substringSQL(1, 30);
/* 151 */
/* 152 */         }
/* 153 */         project_holder.reset();
/* 154 */
/* 155 */         project_rowWriter.zeroOutNullBytes();
/* 156 */
/* 157 */         if (smj_isNull9) {
/* 158 */           project_rowWriter.setNullAt(0);
/* 159 */         } else {
/* 160 */           project_rowWriter.write(0, smj_value11);
/* 161 */         }
/* 162 */
/* 163 */         if (smj_isNull8) {
/* 164 */           project_rowWriter.setNullAt(1);
/* 165 */         } else {
/* 166 */           project_rowWriter.write(1, smj_value10);
/* 167 */         }
/* 168 */
/* 169 */         if (project_isNull2) {
/* 170 */           project_rowWriter.setNullAt(2);
/* 171 */         } else {
/* 172 */           project_rowWriter.write(2, project_value2);
/* 173 */         }
/* 174 */
/* 175 */         if (smj_isNull2) {
/* 176 */           project_rowWriter.setNullAt(3);
/* 177 */         } else {
/* 178 */           project_rowWriter.write(3, smj_value4);
/* 179 */         }
/* 180 */
/* 181 */         if (smj_isNull5) {
/* 182 */           project_rowWriter.setNullAt(4);
/* 183 */         } else {
/* 184 */           project_rowWriter.write(4, smj_value7);
/* 185 */         }
/* 186 */
/* 187 */         if (smj_isNull6) {
/* 188 */           project_rowWriter.setNullAt(5);
/* 189 */         } else {
/* 190 */           project_rowWriter.write(5, smj_value8);
/* 191 */         }
/* 192 */
/* 193 */         if (smj_isNull4) {
/* 194 */           project_rowWriter.setNullAt(6);
/* 195 */         } else {
/* 196 */           project_rowWriter.write(6, smj_value6);
/* 197 */         }
/* 198 */         project_result.setTotalSize(project_holder.totalSize());
/* 199 */         append(project_result.copy());
/* 200 */
/* 201 */       }
/* 202 */       if (shouldStop()) return;
/* 203 */     }
/* 204 */   }
/* 205 */ }
