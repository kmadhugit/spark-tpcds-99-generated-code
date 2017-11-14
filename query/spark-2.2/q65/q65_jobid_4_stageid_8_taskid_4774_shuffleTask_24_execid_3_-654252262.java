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
/* 015 */   private UTF8String smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private int smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private double smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private UTF8String smj_value7;
/* 022 */   private boolean smj_isNull5;
/* 023 */   private double smj_value8;
/* 024 */   private boolean smj_isNull6;
/* 025 */   private double smj_value9;
/* 026 */   private boolean smj_isNull7;
/* 027 */   private UTF8String smj_value10;
/* 028 */   private boolean smj_isNull8;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 030 */   private UnsafeRow smj_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 033 */   private UnsafeRow project_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 036 */
/* 037 */   public GeneratedIterator(Object[] references) {
/* 038 */     this.references = references;
/* 039 */   }
/* 040 */
/* 041 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 042 */     partitionIndex = index;
/* 043 */     this.inputs = inputs;
/* 044 */     smj_leftInput = inputs[0];
/* 045 */     smj_rightInput = inputs[1];
/* 046 */
/* 047 */     smj_rightRow = null;
/* 048 */
/* 049 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 050 */
/* 051 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 052 */     smj_result = new UnsafeRow(9);
/* 053 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 96);
/* 054 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 9);
/* 055 */     project_result = new UnsafeRow(6);
/* 056 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 057 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */   private boolean findNextInnerJoinRows(
/* 062 */     scala.collection.Iterator leftIter,
/* 063 */     scala.collection.Iterator rightIter) {
/* 064 */     smj_leftRow = null;
/* 065 */     int comp = 0;
/* 066 */     while (smj_leftRow == null) {
/* 067 */       if (!leftIter.hasNext()) return false;
/* 068 */       smj_leftRow = (InternalRow) leftIter.next();
/* 069 */
/* 070 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 071 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 072 */       if (smj_isNull) {
/* 073 */         smj_leftRow = null;
/* 074 */         continue;
/* 075 */       }
/* 076 */       if (!smj_matches.isEmpty()) {
/* 077 */         comp = 0;
/* 078 */         if (comp == 0) {
/* 079 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 080 */         }
/* 081 */
/* 082 */         if (comp == 0) {
/* 083 */           return true;
/* 084 */         }
/* 085 */         smj_matches.clear();
/* 086 */       }
/* 087 */
/* 088 */       do {
/* 089 */         if (smj_rightRow == null) {
/* 090 */           if (!rightIter.hasNext()) {
/* 091 */             smj_value3 = smj_value;
/* 092 */             return !smj_matches.isEmpty();
/* 093 */           }
/* 094 */           smj_rightRow = (InternalRow) rightIter.next();
/* 095 */
/* 096 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 097 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 098 */           if (smj_isNull1) {
/* 099 */             smj_rightRow = null;
/* 100 */             continue;
/* 101 */           }
/* 102 */           smj_value2 = smj_value1;
/* 103 */         }
/* 104 */
/* 105 */         comp = 0;
/* 106 */         if (comp == 0) {
/* 107 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 108 */         }
/* 109 */
/* 110 */         if (comp > 0) {
/* 111 */           smj_rightRow = null;
/* 112 */         } else if (comp < 0) {
/* 113 */           if (!smj_matches.isEmpty()) {
/* 114 */             smj_value3 = smj_value;
/* 115 */             return true;
/* 116 */           }
/* 117 */           smj_leftRow = null;
/* 118 */         } else {
/* 119 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 120 */           smj_rightRow = null;;
/* 121 */         }
/* 122 */       } while (smj_leftRow != null);
/* 123 */     }
/* 124 */     return false; // unreachable
/* 125 */   }
/* 126 */
/* 127 */   protected void processNext() throws java.io.IOException {
/* 128 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 129 */       boolean smj_loaded = false;
/* 130 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 131 */       smj_value6 = smj_isNull4 ? -1.0 : (smj_leftRow.getDouble(2));
/* 132 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 133 */       while (smj_iterator.hasNext()) {
/* 134 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 135 */         double smj_value12 = smj_rightRow1.getDouble(1);
/* 136 */
/* 137 */         boolean smj_isNull11 = true;
/* 138 */         boolean smj_value13 = false;
/* 139 */
/* 140 */         if (!smj_isNull4) {
/* 141 */           boolean smj_isNull13 = false;
/* 142 */
/* 143 */           double smj_value15 = -1.0;
/* 144 */           smj_value15 = 0.1D * smj_value12;
/* 145 */
/* 146 */           smj_isNull11 = false; // resultCode could change nullability.
/* 147 */           smj_value13 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value6, smj_value15) <= 0;
/* 148 */
/* 149 */         }
/* 150 */         if (smj_isNull11 || !smj_value13) continue;
/* 151 */         if (!smj_loaded) {
/* 152 */           smj_loaded = true;
/* 153 */           smj_isNull2 = smj_leftRow.isNullAt(0);
/* 154 */           smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 155 */           smj_isNull3 = smj_leftRow.isNullAt(1);
/* 156 */           smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 157 */           smj_isNull5 = smj_leftRow.isNullAt(3);
/* 158 */           smj_value7 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(3));
/* 159 */           smj_isNull6 = smj_leftRow.isNullAt(4);
/* 160 */           smj_value8 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(4));
/* 161 */           smj_isNull7 = smj_leftRow.isNullAt(5);
/* 162 */           smj_value9 = smj_isNull7 ? -1.0 : (smj_leftRow.getDouble(5));
/* 163 */           smj_isNull8 = smj_leftRow.isNullAt(6);
/* 164 */           smj_value10 = smj_isNull8 ? null : (smj_leftRow.getUTF8String(6));
/* 165 */         }
/* 166 */         boolean smj_isNull9 = smj_rightRow1.isNullAt(0);
/* 167 */         int smj_value11 = smj_isNull9 ? -1 : (smj_rightRow1.getInt(0));
/* 168 */         smj_numOutputRows.add(1);
/* 169 */
/* 170 */         project_holder.reset();
/* 171 */
/* 172 */         project_rowWriter.zeroOutNullBytes();
/* 173 */
/* 174 */         if (smj_isNull2) {
/* 175 */           project_rowWriter.setNullAt(0);
/* 176 */         } else {
/* 177 */           project_rowWriter.write(0, smj_value4);
/* 178 */         }
/* 179 */
/* 180 */         if (smj_isNull5) {
/* 181 */           project_rowWriter.setNullAt(1);
/* 182 */         } else {
/* 183 */           project_rowWriter.write(1, smj_value7);
/* 184 */         }
/* 185 */
/* 186 */         if (smj_isNull4) {
/* 187 */           project_rowWriter.setNullAt(2);
/* 188 */         } else {
/* 189 */           project_rowWriter.write(2, smj_value6);
/* 190 */         }
/* 191 */
/* 192 */         if (smj_isNull6) {
/* 193 */           project_rowWriter.setNullAt(3);
/* 194 */         } else {
/* 195 */           project_rowWriter.write(3, smj_value8);
/* 196 */         }
/* 197 */
/* 198 */         if (smj_isNull7) {
/* 199 */           project_rowWriter.setNullAt(4);
/* 200 */         } else {
/* 201 */           project_rowWriter.write(4, smj_value9);
/* 202 */         }
/* 203 */
/* 204 */         if (smj_isNull8) {
/* 205 */           project_rowWriter.setNullAt(5);
/* 206 */         } else {
/* 207 */           project_rowWriter.write(5, smj_value10);
/* 208 */         }
/* 209 */         project_result.setTotalSize(project_holder.totalSize());
/* 210 */         append(project_result.copy());
/* 211 */
/* 212 */       }
/* 213 */       if (shouldStop()) return;
/* 214 */     }
/* 215 */   }
/* 216 */ }
