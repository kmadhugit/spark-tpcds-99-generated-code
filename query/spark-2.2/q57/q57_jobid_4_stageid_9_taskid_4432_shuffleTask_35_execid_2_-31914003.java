/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator inputadapter_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 010 */   private UnsafeRow filter_result;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 012 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 013 */
/* 014 */   public GeneratedIterator(Object[] references) {
/* 015 */     this.references = references;
/* 016 */   }
/* 017 */
/* 018 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 019 */     partitionIndex = index;
/* 020 */     this.inputs = inputs;
/* 021 */     inputadapter_input = inputs[0];
/* 022 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 023 */     filter_result = new UnsafeRow(8);
/* 024 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 96);
/* 025 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 8);
/* 026 */
/* 027 */   }
/* 028 */
/* 029 */   protected void processNext() throws java.io.IOException {
/* 030 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 031 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 032 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 033 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 034 */
/* 035 */       if (!(!(inputadapter_isNull3))) continue;
/* 036 */
/* 037 */       boolean filter_isNull2 = false;
/* 038 */
/* 039 */       boolean filter_value2 = false;
/* 040 */       filter_value2 = inputadapter_value3 == 1999;
/* 041 */       if (!filter_value2) continue;
/* 042 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 043 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 044 */
/* 045 */       if (!(!(inputadapter_isNull6))) continue;
/* 046 */
/* 047 */       boolean filter_isNull7 = false;
/* 048 */
/* 049 */       boolean filter_value7 = false;
/* 050 */       filter_value7 = org.apache.spark.util.Utils.nanSafeCompareDoubles(inputadapter_value6, 0.0D) > 0;
/* 051 */       if (!filter_value7) continue;
/* 052 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 053 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 054 */
/* 055 */       boolean filter_isNull10 = true;
/* 056 */       boolean filter_value10 = false;
/* 057 */
/* 058 */       boolean filter_isNull11 = true;
/* 059 */       double filter_value11 = -1.0;
/* 060 */
/* 061 */       boolean filter_isNull12 = false;
/* 062 */
/* 063 */       boolean filter_value12 = false;
/* 064 */       filter_value12 = org.apache.spark.util.Utils.nanSafeCompareDoubles(inputadapter_value6, 0.0D) > 0;
/* 065 */       if (!false && filter_value12) {
/* 066 */         boolean filter_isNull15 = false;
/* 067 */         double filter_value15 = -1.0;
/* 068 */         if (inputadapter_isNull6 || inputadapter_value6 == 0) {
/* 069 */           filter_isNull15 = true;
/* 070 */         } else {
/* 071 */           boolean filter_isNull17 = true;
/* 072 */           double filter_value17 = -1.0;
/* 073 */
/* 074 */           if (!inputadapter_isNull5) {
/* 075 */             filter_isNull17 = false; // resultCode could change nullability.
/* 076 */             filter_value17 = inputadapter_value5 - inputadapter_value6;
/* 077 */
/* 078 */           }
/* 079 */           boolean filter_isNull16 = filter_isNull17;
/* 080 */           double filter_value16 = -1.0;
/* 081 */
/* 082 */           if (!filter_isNull17) {
/* 083 */             filter_value16 = (double)(java.lang.Math.abs(filter_value17));
/* 084 */           }
/* 085 */           if (filter_isNull16) {
/* 086 */             filter_isNull15 = true;
/* 087 */           } else {
/* 088 */             filter_value15 = (double)(filter_value16 / inputadapter_value6);
/* 089 */           }
/* 090 */         }
/* 091 */         filter_isNull11 = filter_isNull15;
/* 092 */         filter_value11 = filter_value15;
/* 093 */       }
/* 094 */
/* 095 */       else {
/* 096 */         final double filter_value21 = -1.0;
/* 097 */         filter_isNull11 = true;
/* 098 */         filter_value11 = filter_value21;
/* 099 */       }
/* 100 */       if (!filter_isNull11) {
/* 101 */         filter_isNull10 = false; // resultCode could change nullability.
/* 102 */         filter_value10 = org.apache.spark.util.Utils.nanSafeCompareDoubles(filter_value11, 0.1D) > 0;
/* 103 */
/* 104 */       }
/* 105 */       if (filter_isNull10 || !filter_value10) continue;
/* 106 */
/* 107 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 108 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 109 */
/* 110 */       if (!(!(inputadapter_isNull7))) continue;
/* 111 */
/* 112 */       filter_numOutputRows.add(1);
/* 113 */
/* 114 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 115 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 116 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 117 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 118 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 119 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 120 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 121 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 122 */       filter_holder.reset();
/* 123 */
/* 124 */       filter_rowWriter.zeroOutNullBytes();
/* 125 */
/* 126 */       if (inputadapter_isNull) {
/* 127 */         filter_rowWriter.setNullAt(0);
/* 128 */       } else {
/* 129 */         filter_rowWriter.write(0, inputadapter_value);
/* 130 */       }
/* 131 */
/* 132 */       if (inputadapter_isNull1) {
/* 133 */         filter_rowWriter.setNullAt(1);
/* 134 */       } else {
/* 135 */         filter_rowWriter.write(1, inputadapter_value1);
/* 136 */       }
/* 137 */
/* 138 */       if (inputadapter_isNull2) {
/* 139 */         filter_rowWriter.setNullAt(2);
/* 140 */       } else {
/* 141 */         filter_rowWriter.write(2, inputadapter_value2);
/* 142 */       }
/* 143 */
/* 144 */       filter_rowWriter.write(3, inputadapter_value3);
/* 145 */
/* 146 */       if (inputadapter_isNull4) {
/* 147 */         filter_rowWriter.setNullAt(4);
/* 148 */       } else {
/* 149 */         filter_rowWriter.write(4, inputadapter_value4);
/* 150 */       }
/* 151 */
/* 152 */       if (inputadapter_isNull5) {
/* 153 */         filter_rowWriter.setNullAt(5);
/* 154 */       } else {
/* 155 */         filter_rowWriter.write(5, inputadapter_value5);
/* 156 */       }
/* 157 */
/* 158 */       filter_rowWriter.write(6, inputadapter_value6);
/* 159 */
/* 160 */       filter_rowWriter.write(7, inputadapter_value7);
/* 161 */       filter_result.setTotalSize(filter_holder.totalSize());
/* 162 */       append(filter_result);
/* 163 */       if (shouldStop()) return;
/* 164 */     }
/* 165 */   }
/* 166 */ }
