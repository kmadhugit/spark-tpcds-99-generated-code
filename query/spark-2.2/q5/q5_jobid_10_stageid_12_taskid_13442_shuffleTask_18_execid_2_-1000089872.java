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
/* 012 */   private long smj_value6;
/* 013 */   private long smj_value7;
/* 014 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 015 */   private long smj_value8;
/* 016 */   private long smj_value9;
/* 017 */   private long smj_value10;
/* 018 */   private boolean smj_isNull6;
/* 019 */   private long smj_value11;
/* 020 */   private boolean smj_isNull7;
/* 021 */   private double smj_value12;
/* 022 */   private boolean smj_isNull8;
/* 023 */   private double smj_value13;
/* 024 */   private boolean smj_isNull9;
/* 025 */   private int smj_value14;
/* 026 */   private boolean smj_isNull10;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 028 */   private UnsafeRow smj_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 031 */   private UnsafeRow project_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 034 */
/* 035 */   public GeneratedIterator(Object[] references) {
/* 036 */     this.references = references;
/* 037 */   }
/* 038 */
/* 039 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 040 */     partitionIndex = index;
/* 041 */     this.inputs = inputs;
/* 042 */     smj_leftInput = inputs[0];
/* 043 */     smj_rightInput = inputs[1];
/* 044 */
/* 045 */     smj_rightRow = null;
/* 046 */
/* 047 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 048 */
/* 049 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 050 */     smj_result = new UnsafeRow(8);
/* 051 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 052 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 8);
/* 053 */     project_result = new UnsafeRow(6);
/* 054 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 055 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 056 */
/* 057 */   }
/* 058 */
/* 059 */   private boolean findNextInnerJoinRows(
/* 060 */     scala.collection.Iterator leftIter,
/* 061 */     scala.collection.Iterator rightIter) {
/* 062 */     smj_leftRow = null;
/* 063 */     int comp = 0;
/* 064 */     while (smj_leftRow == null) {
/* 065 */       if (!leftIter.hasNext()) return false;
/* 066 */       smj_leftRow = (InternalRow) leftIter.next();
/* 067 */
/* 068 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 069 */       long smj_value = smj_isNull ? -1L : (smj_leftRow.getLong(0));
/* 070 */
/* 071 */       boolean smj_isNull1 = smj_leftRow.isNullAt(1);
/* 072 */       long smj_value1 = smj_isNull1 ? -1L : (smj_leftRow.getLong(1));
/* 073 */       if (smj_isNull || smj_isNull1) {
/* 074 */         smj_leftRow = null;
/* 075 */         continue;
/* 076 */       }
/* 077 */       if (!smj_matches.isEmpty()) {
/* 078 */         comp = 0;
/* 079 */         if (comp == 0) {
/* 080 */           comp = (smj_value > smj_value8 ? 1 : smj_value < smj_value8 ? -1 : 0);
/* 081 */         }
/* 082 */         if (comp == 0) {
/* 083 */           comp = (smj_value1 > smj_value9 ? 1 : smj_value1 < smj_value9 ? -1 : 0);
/* 084 */         }
/* 085 */
/* 086 */         if (comp == 0) {
/* 087 */           return true;
/* 088 */         }
/* 089 */         smj_matches.clear();
/* 090 */       }
/* 091 */
/* 092 */       do {
/* 093 */         if (smj_rightRow == null) {
/* 094 */           if (!rightIter.hasNext()) {
/* 095 */             smj_value8 = smj_value;
/* 096 */             smj_value9 = smj_value1;
/* 097 */             return !smj_matches.isEmpty();
/* 098 */           }
/* 099 */           smj_rightRow = (InternalRow) rightIter.next();
/* 100 */
/* 101 */           boolean smj_isNull3 = smj_rightRow.isNullAt(0);
/* 102 */           int smj_value3 = smj_isNull3 ? -1 : (smj_rightRow.getInt(0));
/* 103 */           boolean smj_isNull2 = smj_isNull3;
/* 104 */           long smj_value2 = -1L;
/* 105 */           if (!smj_isNull3) {
/* 106 */             smj_value2 = (long) smj_value3;
/* 107 */           }
/* 108 */
/* 109 */           boolean smj_isNull5 = smj_rightRow.isNullAt(2);
/* 110 */           int smj_value5 = smj_isNull5 ? -1 : (smj_rightRow.getInt(2));
/* 111 */           boolean smj_isNull4 = smj_isNull5;
/* 112 */           long smj_value4 = -1L;
/* 113 */           if (!smj_isNull5) {
/* 114 */             smj_value4 = (long) smj_value5;
/* 115 */           }
/* 116 */           if (smj_isNull2 || smj_isNull4) {
/* 117 */             smj_rightRow = null;
/* 118 */             continue;
/* 119 */           }
/* 120 */           smj_value6 = smj_value2;
/* 121 */           smj_value7 = smj_value4;
/* 122 */         }
/* 123 */
/* 124 */         comp = 0;
/* 125 */         if (comp == 0) {
/* 126 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 127 */         }
/* 128 */         if (comp == 0) {
/* 129 */           comp = (smj_value1 > smj_value7 ? 1 : smj_value1 < smj_value7 ? -1 : 0);
/* 130 */         }
/* 131 */
/* 132 */         if (comp > 0) {
/* 133 */           smj_rightRow = null;
/* 134 */         } else if (comp < 0) {
/* 135 */           if (!smj_matches.isEmpty()) {
/* 136 */             smj_value8 = smj_value;
/* 137 */             smj_value9 = smj_value1;
/* 138 */             return true;
/* 139 */           }
/* 140 */           smj_leftRow = null;
/* 141 */         } else {
/* 142 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 143 */           smj_rightRow = null;;
/* 144 */         }
/* 145 */       } while (smj_leftRow != null);
/* 146 */     }
/* 147 */     return false; // unreachable
/* 148 */   }
/* 149 */
/* 150 */   protected void processNext() throws java.io.IOException {
/* 151 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 152 */       smj_isNull6 = smj_leftRow.isNullAt(0);
/* 153 */       smj_value10 = smj_isNull6 ? -1L : (smj_leftRow.getLong(0));
/* 154 */       smj_isNull7 = smj_leftRow.isNullAt(1);
/* 155 */       smj_value11 = smj_isNull7 ? -1L : (smj_leftRow.getLong(1));
/* 156 */       smj_isNull8 = smj_leftRow.isNullAt(2);
/* 157 */       smj_value12 = smj_isNull8 ? -1.0 : (smj_leftRow.getDouble(2));
/* 158 */       smj_isNull9 = smj_leftRow.isNullAt(3);
/* 159 */       smj_value13 = smj_isNull9 ? -1.0 : (smj_leftRow.getDouble(3));
/* 160 */       smj_isNull10 = smj_leftRow.isNullAt(4);
/* 161 */       smj_value14 = smj_isNull10 ? -1 : (smj_leftRow.getInt(4));
/* 162 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 163 */       while (smj_iterator.hasNext()) {
/* 164 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 165 */
/* 166 */         smj_numOutputRows.add(1);
/* 167 */
/* 168 */         boolean smj_isNull12 = smj_rightRow1.isNullAt(1);
/* 169 */         int smj_value16 = smj_isNull12 ? -1 : (smj_rightRow1.getInt(1));
/* 170 */         project_rowWriter.zeroOutNullBytes();
/* 171 */
/* 172 */         if (smj_isNull12) {
/* 173 */           project_rowWriter.setNullAt(0);
/* 174 */         } else {
/* 175 */           project_rowWriter.write(0, smj_value16);
/* 176 */         }
/* 177 */
/* 178 */         if (smj_isNull10) {
/* 179 */           project_rowWriter.setNullAt(1);
/* 180 */         } else {
/* 181 */           project_rowWriter.write(1, smj_value14);
/* 182 */         }
/* 183 */
/* 184 */         project_rowWriter.write(2, 0.0D);
/* 185 */
/* 186 */         project_rowWriter.write(3, 0.0D);
/* 187 */
/* 188 */         if (smj_isNull8) {
/* 189 */           project_rowWriter.setNullAt(4);
/* 190 */         } else {
/* 191 */           project_rowWriter.write(4, smj_value12);
/* 192 */         }
/* 193 */
/* 194 */         if (smj_isNull9) {
/* 195 */           project_rowWriter.setNullAt(5);
/* 196 */         } else {
/* 197 */           project_rowWriter.write(5, smj_value13);
/* 198 */         }
/* 199 */         append(project_result.copy());
/* 200 */
/* 201 */       }
/* 202 */       if (shouldStop()) return;
/* 203 */     }
/* 204 */   }
/* 205 */ }
