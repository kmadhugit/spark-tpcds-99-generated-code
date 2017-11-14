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
/* 038 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 039 */
/* 040 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 041 */     smj_result = new UnsafeRow(4);
/* 042 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 64);
/* 043 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 4);
/* 044 */     project_result = new UnsafeRow(3);
/* 045 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 046 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
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
/* 108 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 109 */           smj_rightRow = null;;
/* 110 */         }
/* 111 */       } while (smj_leftRow != null);
/* 112 */     }
/* 113 */     return false; // unreachable
/* 114 */   }
/* 115 */
/* 116 */   protected void processNext() throws java.io.IOException {
/* 117 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 118 */       boolean smj_loaded = false;
/* 119 */       smj_value5 = smj_leftRow.getDouble(1);
/* 120 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 121 */       while (smj_iterator.hasNext()) {
/* 122 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 123 */         double smj_value7 = smj_rightRow1.getDouble(1);
/* 124 */
/* 125 */         boolean smj_isNull8 = false;
/* 126 */
/* 127 */         boolean smj_isNull10 = false;
/* 128 */
/* 129 */         double smj_value13 = -1.0;
/* 130 */         smj_value13 = 0.9D * smj_value7;
/* 131 */         boolean smj_value11 = false;
/* 132 */         smj_value11 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value5, smj_value13) >= 0;
/* 133 */         boolean smj_value10 = false;
/* 134 */
/* 135 */         if (smj_value11) {
/* 136 */           boolean smj_isNull13 = false;
/* 137 */
/* 138 */           boolean smj_isNull15 = false;
/* 139 */
/* 140 */           double smj_value18 = -1.0;
/* 141 */           smj_value18 = 1.1D * smj_value7;
/* 142 */           boolean smj_value16 = false;
/* 143 */           smj_value16 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value5, smj_value18) <= 0;
/* 144 */           smj_value10 = smj_value16;
/* 145 */         }
/* 146 */         boolean smj_value9 = false;
/* 147 */
/* 148 */         if (smj_value10) {
/* 149 */           boolean smj_isNull18 = false;
/* 150 */
/* 151 */           boolean smj_isNull20 = false;
/* 152 */
/* 153 */           double smj_value23 = -1.0;
/* 154 */           smj_value23 = 0.9D * smj_value5;
/* 155 */           boolean smj_value21 = false;
/* 156 */           smj_value21 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value7, smj_value23) >= 0;
/* 157 */           smj_value9 = smj_value21;
/* 158 */         }
/* 159 */         boolean smj_value8 = false;
/* 160 */
/* 161 */         if (smj_value9) {
/* 162 */           boolean smj_isNull23 = false;
/* 163 */
/* 164 */           boolean smj_isNull25 = false;
/* 165 */
/* 166 */           double smj_value28 = -1.0;
/* 167 */           smj_value28 = 1.1D * smj_value5;
/* 168 */           boolean smj_value26 = false;
/* 169 */           smj_value26 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value7, smj_value28) <= 0;
/* 170 */           smj_value8 = smj_value26;
/* 171 */         }
/* 172 */         if (false || !smj_value8) continue;
/* 173 */         if (!smj_loaded) {
/* 174 */           smj_loaded = true;
/* 175 */           smj_isNull2 = smj_leftRow.isNullAt(0);
/* 176 */           smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 177 */         }
/* 178 */         boolean smj_isNull3 = smj_rightRow1.isNullAt(0);
/* 179 */         UTF8String smj_value6 = smj_isNull3 ? null : (smj_rightRow1.getUTF8String(0));
/* 180 */         smj_numOutputRows.add(1);
/* 181 */
/* 182 */         project_holder.reset();
/* 183 */
/* 184 */         project_rowWriter.zeroOutNullBytes();
/* 185 */
/* 186 */         if (smj_isNull2) {
/* 187 */           project_rowWriter.setNullAt(0);
/* 188 */         } else {
/* 189 */           project_rowWriter.write(0, smj_value4);
/* 190 */         }
/* 191 */
/* 192 */         project_rowWriter.write(1, smj_value5);
/* 193 */
/* 194 */         project_rowWriter.write(2, smj_value7);
/* 195 */         project_result.setTotalSize(project_holder.totalSize());
/* 196 */         append(project_result.copy());
/* 197 */
/* 198 */       }
/* 199 */       if (shouldStop()) return;
/* 200 */     }
/* 201 */   }
/* 202 */ }
